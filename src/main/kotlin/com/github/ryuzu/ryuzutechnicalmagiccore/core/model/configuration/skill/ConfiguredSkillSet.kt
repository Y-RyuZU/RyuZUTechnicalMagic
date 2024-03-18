package com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.skill

import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.skill.SkillTrigger

data class ConfiguredSkillSet (
    val relations: LinkedHashSet<List<String>> = linkedSetOf(),
    val skills: HashMap<SkillTrigger, List<String>> = hashMapOf()
)