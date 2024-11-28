package dev.ryuzu.ryuzutechnicalmagic.api.core.model.configuration.general

import dev.ryuzu.ryuzutechnicalmagic.api.core.model.configuration.util.effect.ConfiguredEffect

data class ConfiguredGeneratorParameter(
    val littleStarItem: String,
    val bigStarItem: String,
    val starLostScatter: Double = 0.2,
    val hyperItem: String,
    val effect: ConfiguredEffect,
)
