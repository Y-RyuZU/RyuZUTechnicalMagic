package com.github.ryuzu.ryuzutechnicalmagiccore.core.model.skill.service

import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.skill.ConfiguredSkillParams
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.skill.ConfiguredSkillSet
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.skill.ISkill
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.skill.SkillId
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.skill.SkillTrigger
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.skill.param.ISkillEventPrams
import com.github.ryuzu.ryuzutechnicalmagiccore.core.util.TypedMap
import org.koin.core.annotation.Single
import org.koin.core.component.inject
import org.koin.core.parameter.parameterSetOf
import org.reflections.Reflections
import java.util.*
import kotlin.collections.HashMap

@Single
class SkillService : ISkillService {
    private val skillSets: HashMap<String, ConfiguredSkillSet> by inject { parameterSetOf(ConfiguredSkillSet::class.java) }
    private val skills: HashMap<String, ConfiguredSkillParams> by inject()
    private val skillClasses: Map<String, ISkill> = getSkillClasses()
    private val states = mutableMapOf<UUID, MutableList<SkillState>>()

    private fun getSkillClasses(): Map<String, ISkill> {
        val skills = mutableMapOf<String, ISkill>()
        val reflections = Reflections("com.github.ryuzu.ryuzutechnicalmagiccore.minecraft.implementation.skill")

        reflections.getTypesAnnotatedWith(SkillId::class.java).forEach { classWithAnnotation ->
            val annotation = classWithAnnotation.getAnnotation(SkillId::class.java)
            val instance = classWithAnnotation.getDeclaredConstructor().newInstance()
            if (instance is ISkill)
                skills[annotation.id] = instance
        }

        return skills
    }

    override fun bindSkillToItem(itemId: String, skillSet: ConfiguredSkillSet) {
        skillSets[itemId] = skillSet
    }

    override fun registerSkill(skillId: String, skillParams: ConfiguredSkillParams) {
        skills[skillId] = skillParams
    }

    override fun use(eventParams: ISkillEventPrams) {
        val boundSkills: Set<String> = getFirstSkillIds(eventParams.skillSetId, eventParams.skillTrigger) ?: return
        getSkillsConfig(boundSkills).forEach {
            val nextSkillIds = getNextSkillIds(eventParams.skillSetId, eventParams.skillId)
            if(nextSkillIds.isEmpty())
                use(it.id, eventParams)
            else
                use(it.id, eventParams, SkillState(nextSkillIds))
        }
    }

    private fun getSkillsConfig(skillIds: Set<String>): Set<ConfiguredSkillParams> = skillIds.mapNotNull { skills[it] }.toSet()

    private fun use(skillClassId: String, eventParams: ISkillEventPrams, state: SkillState? = null) {
        val data = TypedMap()
        skillClasses[skillClassId]?.use(skills[skillClassId]!!, eventParams, data , state?.setEventParams(eventParams)?.setDataCaller { data })
    }

    private fun getFirstSkillIds(skillSetId: String, skillTrigger: SkillTrigger): Set<String>? {
        val skillSet = skillSets[skillSetId] ?: return null
        val skills = skillSet.skills[skillTrigger] ?: return null

        return skills.filter { skillId -> skillSet.relations.any{ it.first() == skillId} }.toSet()
    }

    private fun getNextSkillIds(skillSetId: String, skillId: String): Map<SkillTrigger, String> {
        val nextSkillIds = getNextSkillIdsFromSkillSet(skillSetId, skillId)
        return associateByTrigger(skillSetId, nextSkillIds)
    }

    private fun getNextSkillIdsFromSkillSet(skillSetId: String, skillId: String): Set<String> {
        return skillSets[skillSetId]
            ?.relations
            ?.filter { it.contains(skillId) }
            ?.mapNotNull { it.nextTo(skillId) }
            ?.toSet()
            ?: emptySet()
    }

    private fun associateByTrigger(skillSetId: String, skillIds: Set<String>): Map<SkillTrigger, String> {
        return skillIds.associateBy { getTrigger(skillSetId, it) }.toMap()
    }

    private fun getTrigger(skillSetId: String, skillId: String): SkillTrigger {
        return skillSets[skillSetId]?.skills?.filterValues { it.contains(skillId) }?.keys?.first()
            ?: throw IllegalArgumentException("Skill not found")
    }

    private fun List<String>.nextTo(item: String): String? {
        val index = indexOf(item)
        return getOrNull(index + 1)
    }


    override fun addState(id: UUID, state: SkillState) {
        val hasStates = states.getOrPut(id) { mutableListOf() }
        hasStates.add(state)
    }

    override fun getSkillSetIds(id: UUID, skillTrigger: SkillTrigger): List<String>? {
        val hasStates = getStates(id, skillTrigger) ?: return null
        return hasStates.map { it.eventParams.skillSetId }
    }

    override fun transitionState(id: UUID, eventParams: ISkillEventPrams.ICasterEventParams) {
        val hasStates = getStates(id, eventParams.skillTrigger) ?: return
        hasStates.forEach {
            val nextSkillIds = getNextSkillIds(eventParams.skillSetId, eventParams.skillId)
            use(eventParams.skillId, eventParams, SkillState(nextSkillIds, it))
        }
        states[id]?.removeAll(hasStates)
    }

    private fun getStates(id: UUID, skillTrigger: SkillTrigger): List<SkillState>? {
        return states[id]?.filter{ it.nextSkillIds.contains(skillTrigger) }
    }

    override fun clearStates(id: UUID) {
        states.remove(id)
    }
}