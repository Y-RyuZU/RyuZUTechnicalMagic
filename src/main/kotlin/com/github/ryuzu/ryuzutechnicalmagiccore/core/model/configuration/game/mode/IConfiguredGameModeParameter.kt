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
    val maximumPlayerCount: Int
    val minimumPlayerCount: Int

    data class ConfiguredCarryTNTParameter(
        override val duration: Long,
        override val maximumPlayerCount: Int,
        override val minimumPlayerCount: Int,
        val getTNTDuration: Long,
    ) : IConfiguredGameModeParameter

    data class ConfiguredCaptureWoolParameter(
        override val duration: Long,
        override val maximumPlayerCount: Int,
        override val minimumPlayerCount: Int,
        val captureDuration: Long,
    ) : IConfiguredGameModeParameter
}