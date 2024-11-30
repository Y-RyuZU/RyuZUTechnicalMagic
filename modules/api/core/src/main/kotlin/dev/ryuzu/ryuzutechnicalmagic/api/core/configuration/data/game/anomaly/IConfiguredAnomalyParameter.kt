package dev.ryuzu.ryuzutechnicalmagic.api.core.configuration.data.game.anomaly

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
    ) : dev.ryuzu.ryuzutechnicalmagic.api.core.configuration.data.game.anomaly.IConfiguredAnomalyParameter

    @Serializable
    @SerialName("freeze")
    data class ConfiguredFreezeParameter(
        override val probability: Double,
        override val duration: Int,
    ) : dev.ryuzu.ryuzutechnicalmagic.api.core.configuration.data.game.anomaly.IConfiguredAnomalyParameter
}