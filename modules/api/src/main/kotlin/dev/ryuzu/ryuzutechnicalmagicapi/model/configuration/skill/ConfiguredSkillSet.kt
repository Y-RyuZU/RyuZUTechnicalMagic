package dev.ryuzu.ryuzutechnicalmagicapi.model.configuration.skill

import dev.ryuzu.ryuzutechnicalmagicapi.model.skill.SkillTrigger

data class ConfiguredSkillSet (
    val relations: LinkedHashSet<List<String>> = linkedSetOf(),
    val skills: Map<SkillTrigger, Set<String>> = mapOf()
)