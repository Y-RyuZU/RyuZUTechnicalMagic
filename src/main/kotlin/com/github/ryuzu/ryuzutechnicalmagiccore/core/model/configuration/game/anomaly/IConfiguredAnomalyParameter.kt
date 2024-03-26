package com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.game.anomaly

import com.fasterxml.jackson.annotation.JsonSubTypes
import com.fasterxml.jackson.annotation.JsonTypeInfo
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.game.stage.anomaly.AnomalyType

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "Type")
@JsonSubTypes(
    JsonSubTypes.Type(value = IConfiguredAnomalyParameter.ConfiguredMeteorParameter::class, name = AnomalyType.CONST_METEOR),
    JsonSubTypes.Type(value = IConfiguredAnomalyParameter.ConfiguredFreezeParameter::class, name = AnomalyType.CONST_FREEZE)
)
sealed interface IConfiguredAnomalyParameter {
    val probability: Double
    val duration: Int

    data class ConfiguredMeteorParameter(
        override val probability: Double,
        override val duration: Int,
        val radius: Double,
    ) : IConfiguredAnomalyParameter

    data class ConfiguredFreezeParameter(
        override val probability: Double,
        override val duration: Int,
    ) : IConfiguredAnomalyParameter
}