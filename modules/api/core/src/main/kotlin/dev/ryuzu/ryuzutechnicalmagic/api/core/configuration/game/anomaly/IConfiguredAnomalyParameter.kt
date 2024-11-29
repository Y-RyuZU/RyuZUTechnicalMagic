package dev.ryuzu.ryuzutechnicalmagic.api.core.configuration.game.anomaly

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
sealed interface IConfiguredAnomalyParameter {
    val probability: Double
    val duration: Int

    @Serializable
    @SerialName("meteor")
    data class ConfiguredMeteorParameter(
        override val probability: Double,
        override val duration: Int,
        val radius: Double,
    ) : IConfiguredAnomalyParameter

    @Serializable
    @SerialName("freeze")
    data class ConfiguredFreezeParameter(
        override val probability: Double,
        override val duration: Int,
    ) : IConfiguredAnomalyParameter
}