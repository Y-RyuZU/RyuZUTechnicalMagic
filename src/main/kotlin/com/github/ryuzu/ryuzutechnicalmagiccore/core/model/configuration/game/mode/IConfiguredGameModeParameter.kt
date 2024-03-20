package com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.game.mode

import com.fasterxml.jackson.annotation.JsonSubTypes
import com.fasterxml.jackson.annotation.JsonTypeInfo

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "GameMode")
@JsonSubTypes(
    JsonSubTypes.Type(value = IConfiguredGameModeParameter.ConfiguredCarryTNTParameter::class, name = "CarryTNT"),
    JsonSubTypes.Type(value = IConfiguredGameModeParameter.ConfiguredCaptureWoolParameter::class, name = "CaptureWool")
)
sealed interface IConfiguredGameModeParameter {
    val duration: Long

    data class ConfiguredCarryTNTParameter(
        override val duration: Long,
        val getTNTDuration: Long,
    ) : IConfiguredGameModeParameter

    data class ConfiguredCaptureWoolParameter(
        override val duration: Long,
        val captureDuration: Long,
    ) : IConfiguredGameModeParameter
}