package dev.ryuzu.ryuzutechnicalmagic.api.core.configuration.skill

import dev.ryuzu.ryuzutechnicalmagic.api.core.model.skill.SkillTrigger

data class ConfiguredSkillSet (
    val relations: LinkedHashSet<List<String>> = linkedSetOf(),
    val skills: Map<SkillTrigger, Set<String>> = mapOf()
)