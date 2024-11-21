package dev.ryuzu.ryuzutechnicalmagiccore.model.configuration.skill

import dev.ryuzu.ryuzutechnicalmagiccore.model.skill.SkillTrigger

data class ConfiguredSkillSet (
    val relations: LinkedHashSet<List<String>> = linkedSetOf(),
    val skills: Map<SkillTrigger, Set<String>> = mapOf()
)