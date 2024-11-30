package dev.ryuzu.ryuzutechnicalmagic.api.core.configuration.data.game.anomaly

import dev.ryuzu.ryuzutechnicalmagic.api.core.configuration.skill.effect.ConfiguredEffect

data class ConfiguredAnomaly(
    val name: String,
    val description: List<String>,
    val effect: ConfiguredEffect,
)
