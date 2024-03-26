package com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.game.anomaly

import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.util.ConfiguredEffect

data class ConfiguredAnomaly(
    val name: String,
    val description: List<String>,
    val effects: ConfiguredEffect,
)
