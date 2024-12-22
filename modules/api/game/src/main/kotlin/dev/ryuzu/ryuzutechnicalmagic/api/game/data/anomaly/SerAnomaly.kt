package dev.ryuzu.ryuzutechnicalmagic.api.game.data.anomaly

import dev.ryuzu.ryuzutechnicalmagic.api.core.data.effect.SerEffect
import kotlinx.serialization.Serializable

@Serializable
data class SerAnomaly(
    val name: String,
    val description: List<String>,
    val effect: SerEffect,
)
