package dev.ryuzu.ryuzutechnicalmagicapi.model.configuration.game.anomaly

import dev.ryuzu.ryuzutechnicalmagicapi.model.configuration.util.effect.ConfiguredEffect

data class ConfiguredAnomaly(
    val name: String,
    val description: List<String>,
    val effect: ConfiguredEffect,
)
