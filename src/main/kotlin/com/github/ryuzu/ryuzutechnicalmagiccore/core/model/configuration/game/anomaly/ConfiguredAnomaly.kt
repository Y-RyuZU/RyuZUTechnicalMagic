package com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.game.anomaly

import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.util.effect.ConfiguredEffect

data class ConfiguredAnomaly(
    val name: String,
    val description: List<String>,
    val effect: ConfiguredEffect,
)
