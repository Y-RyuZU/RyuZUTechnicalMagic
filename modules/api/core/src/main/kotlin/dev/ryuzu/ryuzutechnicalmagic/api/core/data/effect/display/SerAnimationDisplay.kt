package dev.ryuzu.ryuzutechnicalmagic.api.core.data.effect.display

import kotlinx.serialization.Serializable

@Serializable
data class SerAnimationDisplay(
    val material: String,
    val customModel: Int,
    val frameTime: Int
)
