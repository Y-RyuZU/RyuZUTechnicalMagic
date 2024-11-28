package dev.ryuzu.ryuzutechnicalmagic.api.core.model.configuration.game.anomaly

import dev.ryuzu.ryuzutechnicalmagic.api.core.model.configuration.util.effect.ConfiguredEffect

data class ConfiguredAnomaly(
    val name: String,
    val description: List<String>,
    val effect: ConfiguredEffect,
)
