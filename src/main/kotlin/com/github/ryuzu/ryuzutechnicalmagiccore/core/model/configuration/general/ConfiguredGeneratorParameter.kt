package com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.general

import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.util.effect.ConfiguredEffect

data class ConfiguredGeneratorParameter(
    val littleStarItem: String,
    val bigStarItem: String,
    val starLostScatter: Double = 0.2,
    val hyperItem: String,
    val effect: ConfiguredEffect,
)
