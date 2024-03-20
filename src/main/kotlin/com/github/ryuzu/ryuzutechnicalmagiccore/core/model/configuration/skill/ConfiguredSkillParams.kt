package com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.skill

import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.util.ConfiguredEffect
import com.github.ryuzu.ryuzutechnicalmagiccore.core.util.TypedMap

data class ConfiguredSkillParams (
    val id: String,
    val effects: ConfiguredEffect,
    val performance: TypedMap
)