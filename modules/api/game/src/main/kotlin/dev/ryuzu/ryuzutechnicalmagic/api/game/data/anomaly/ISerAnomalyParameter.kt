package dev.ryuzu.ryuzutechnicalmagic.api.game.data.anomaly

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
sealed interface ISerAnomalyParameter {
    val probability: Double
    val duration: Int
}

@Serializable
@SerialName("freeze")
data class SerFreezeParameter(
    override val probability: Double,
    override val duration: Int,
) : ISerAnomalyParameter

@Serializable
@SerialName("meteor")
data class SerMeteorParameter(
    override val probability: Double,
    override val duration: Int,
    val radius: Double,
) : ISerAnomalyParameter