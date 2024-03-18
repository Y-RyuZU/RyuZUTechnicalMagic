package com.github.ryuzu.ryuzutechnicalmagiccore.core.model.skill.service

import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.skill.ConfiguredSkillParams
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.skill.ConfiguredSkillSet
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.skill.ISkill
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.skill.SkillId
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.skill.SkillTrigger
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.skill.param.ISkillEventPrams
import com.github.ryuzu.ryuzutechnicalmagiccore.core.util.TypedMap
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import org.koin.core.parameter.parameterSetOf
import org.reflections.Reflections
import java.util.*
import kotlin.collections.HashMap

abstract class SkillService : ISkillService, KoinComponent {
    private val itemSkillBinder: HashMap<String, ConfiguredSkillSet> by inject { parameterSetOf(ConfiguredSkillSet::class.java) }
    private val skills: HashMap<String, ConfiguredSkillParams> by inject()
    private val skillClasses: Map<String, ISkill> = getSkillClasses()
    private val relationQueue: MutableMap<UUID, MutableMap<Int, MutableMap<String, MutableMap<String, () -> TypedMap>>>> =
        mutableMapOf()

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

    private fun getSkill(id: String): MutableSet<ConfiguredSkillParams>? =
        SkillTrigger.values().mapNotNull { getSkill(id, it) }.flatten().toMutableSet()

    override fun bindSkillToItem(itemId: String, skillSet: ConfiguredSkillSet) {
        itemSkillBinder[itemId] = skillSet
    }

    override fun registerSkill(skillId: String, skillParams: ConfiguredSkillParams) {
        skills[skillId] = skillParams
    }

    override fun use(skillId: String, eventParams: ISkillEventPrams) {
        skillClasses[skillId]?.use(skills[skillId]!!, eventParams, TypedMap())
    }


    override fun use(trigger: SkillTrigger, eventParams: ISkillEventPrams.ICasterEventParams) {
        itemSkillBinder[eventParams.itemId]?.skills?.get(trigger)?.forEach {
            val skill = skills[it]
            getContexts(eventParams)
                .ifEmpty { listOf(TypedMap()) }
                .forEach { context: TypedMap -> skillClasses[it]?.use(skill!!, eventParams, context) }
        }
    }

    private fun getContexts(eventParams: ISkillEventPrams.ICasterEventParams): List<TypedMap> =
        getBeforeSkills(eventParams).map {
            relationQueue[eventParams.initiator.id]?.get(eventParams.slot)?.get(eventParams.itemId)?.get(it)?.invoke()
                ?: TypedMap()
        }

    private fun getBeforeSkills(eventParams: ISkillEventPrams.ICasterEventParams): List<String> {
        val relations = itemSkillBinder[eventParams.itemId]?.relations.orEmpty()
        val containingRelations = relations.filter { it.contains(eventParams.skillId) }
        return containingRelations.mapNotNull { it.previousTo(eventParams.skillId) }
    }

    private fun List<String>.previousTo(item: String): String? {
        val index = indexOf(item)
        return getOrNull(index - 1)
    }

}