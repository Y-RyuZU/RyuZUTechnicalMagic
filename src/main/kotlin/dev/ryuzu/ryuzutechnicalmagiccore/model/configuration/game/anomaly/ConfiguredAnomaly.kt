package dev.ryuzu.ryuzutechnicalmagiccore.model.configuration.game.anomaly

import dev.ryuzu.ryuzutechnicalmagiccore.model.configuration.util.effect.ConfiguredEffect

data class ConfiguredAnomaly(
    val name: String,
    val description: List<String>,
    val effect: ConfiguredEffect,
)
