package dev.ryuzu.ryuzutechnicalmagic.api.core.data.general

import dev.ryuzu.ryuzutechnicalmagic.api.core.configuration.skill.effect.ConfiguredEffect

data class SerGeneratorParameter(
    val littleStarItem: String,
    val bigStarItem: String,
    val starLostScatter: Double = 0.2,
    val hyperItem: String,
    val effect: ConfiguredEffect,
)
