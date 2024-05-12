package com.github.ryuzu.ryuzutechnicalmagiccore.core.model.skill.service

import com.github.ryuzu.ryuzutechnicalmagiccore.core.event.data.skill.IEntitySkillCastEvent
import com.github.ryuzu.ryuzutechnicalmagiccore.core.event.data.skill.IPlayerSkillCastEvent
import com.github.ryuzu.ryuzutechnicalmagiccore.core.event.data.skill.ISkillActivateEvent
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.skill.ConfiguredSkillParams
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.skill.ConfiguredSkillSet
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.entity.IPlayer
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.skill.ISkill
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.skill.SkillTrigger
import com.github.ryuzu.ryuzutechnicalmagiccore.core.util.TypedMap
import org.koin.core.component.KoinComponent
import org.koin.core.component.get
import org.koin.core.component.inject
import org.koin.core.qualifier.named
import org.reflections.Reflections
import kotlin.collections.HashMap

abstract class AbstractSkillService : ISkillService, KoinComponent {
    private val coolTimeService: ICoolTimeService by inject()

    private var skillSets: HashMap<String, ConfiguredSkillSet> = get(named("SkillSetConfig"))
    private var skills: HashMap<String, ConfiguredSkillParams> = get(named("SkillConfig"))
    private val skillClasses: Map<String, ISkill> = getSkillClasses()
    private val states = mutableMapOf<IPlayer, MutableList<SkillState>>()

    private fun getSkillClasses(): Map<String, ISkill> {
        val reflections = Reflections("com.github.ryuzu.ryuzutechnicalmagiccore.minecraft.implementation.skill")

        return reflections.getSubTypesOf(ISkill::class.java).associateBy({ it.simpleName }, {
            it.getDeclaredConstructor().newInstance()
        })
    }

    override fun bindSkillToItem(itemId: String, skillSet: ConfiguredSkillSet) {
        skillSets[itemId] = skillSet
    }

    override fun registerSkill(skillId: String, skillParams: ConfiguredSkillParams) {
        skills[skillId] = skillParams
    }

    override fun getSkillIds(itemId: String, skillTrigger: SkillTrigger): List<String>? {
        return skillSets[itemId]?.skills?.get(skillTrigger)?.toList()
    }

    override fun use(event: ISkillActivateEvent) {
        val boundSkills: Set<String> = getFirstSkillIds(event.skillSetId, event.skillTrigger) ?: return
        getSkillsConfig(boundSkills).forEach {
            val nextSkillIds = getNextSkillIds(event.skillSetId, event.skillId, 0)

            if (event is IPlayerSkillCastEvent) {
                val relationCoolTime = System.currentTimeMillis() + it.relationExpirationTime
                coolTimeService.setCoolTime(event.player, it.id, relationCoolTime)
            }

            if (nextSkillIds.isEmpty())
                use(it.id, event)
            else {
                val relationCoolTime = System.currentTimeMillis() + it.relationExpirationTime
                use(it.id, event, SkillState(event, nextSkillIds, relationCoolTime))
            }
        }
    }

    private fun getSkillsConfig(skillIds: Set<String>): Set<ConfiguredSkillParams> =
        skillIds.mapNotNull { skills[it] }.toSet()

    private fun use(skillClassId: String, event: ISkillActivateEvent, state: SkillState? = null) {
        val data = TypedMap()
        skillClasses[skillClassId]!!.use(skills[event.skillId]!!, event, data, state?.setDataCaller { data })
    }

    override fun getFirstSkillIds(itemId: String, skillTrigger: SkillTrigger): Set<String>? {
        val skillSet = skillSets[itemId] ?: return null
        val skills = skillSet.skills[skillTrigger] ?: return null

        return skills.filter { skillId -> skillSet.relations.any { it.first() == skillId } }.toSet()
    }

    private fun getNextSkillIds(skillSetId: String, skillId: String, index: Int): Map<SkillTrigger, String> {
        val nextSkillIds = getNextSkillIdsFromSkillSet(skillSetId, skillId, index)
        return associateByTrigger(skillSetId, nextSkillIds)
    }

    private fun getNextSkillIdsFromSkillSet(skillSetId: String, skillId: String, index: Int): Set<String> {
        return skillSets[skillSetId]
            ?.relations
            ?.filter { it.elementAt(index) == skillId }
            ?.mapNotNull { it.getOrNull(index + 1) }
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

    override fun addState(id: IPlayer, state: SkillState) {
        val hasStates = states.getOrPut(id) { mutableListOf() }
        hasStates.add(state)
    }

    override fun getSkillSetIdsFromState(id: IPlayer, skillTrigger: SkillTrigger): List<String>? {
        val hasStates = getStates(id, skillTrigger) ?: return null
        return hasStates.map { it.event.skillSetId }
    }


    override fun transitionState(player: IPlayer, event: IEntitySkillCastEvent) {
        val hasStates = getStates(player, event.skillTrigger) ?: return
        hasStates.forEach {
            if (it.relationExpirationTime > System.currentTimeMillis()) return@forEach

            val originalPlayer = it.getOriginalCasterPlayer()
            val nextSkillIds = getNextSkillIds(event.skillSetId, event.skillId, it.getIndex())
            val relationCoolTime = System.currentTimeMillis() + skills[event.skillId]?.relationExpirationTime!!

            if (originalPlayer != null) coolTimeService.setCoolTime(originalPlayer, event.skillId, relationCoolTime)

            use(event.skillId, event, SkillState(event, nextSkillIds, relationCoolTime, it))
        }
        states[player]?.removeAll(hasStates)
    }

    private fun getStates(player: IPlayer, skillTrigger: SkillTrigger): List<SkillState>? {
        return states[player]?.filter { it.nextSkillIds.containsKey(skillTrigger) }
    }

    override fun clearStates(player: IPlayer) {
        states.remove(player)
    }

    override fun reloadSkill() {
        skills = get(named("SkillConfig"))
    }

    override fun reloadSkillSet() {
        skillSets = get(named("SkillSetConfig"))
    }
}