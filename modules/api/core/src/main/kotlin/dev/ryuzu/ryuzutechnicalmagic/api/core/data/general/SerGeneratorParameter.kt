package dev.ryuzu.ryuzutechnicalmagic.api.core.data.general

import dev.ryuzu.ryuzutechnicalmagic.api.core.data.effect.SerEffect


data class SerGeneratorParameter(
    val littleStarItem: String,
    val bigStarItem: String,
    val starLostScatter: Double = 0.2,
    val hyperItem: String,
    val effect: SerEffect,
)
