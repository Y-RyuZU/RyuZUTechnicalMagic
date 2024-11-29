package dev.ryuzu.ryuzutechnicalmagic.api.core.configuration.game.anomaly

import dev.ryuzu.ryuzutechnicalmagic.api.core.configuration.util.effect.ConfiguredEffect

data class ConfiguredAnomaly(
    val name: String,
    val description: List<String>,
    val effect: dev.ryuzu.ryuzutechnicalmagic.api.core.configuration.util.effect.ConfiguredEffect,
)
