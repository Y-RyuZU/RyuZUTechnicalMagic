package dev.ryuzu.ryuzutechnicalmagic.api.core.configuration.data.game.mode

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
sealed interface IConfiguredGameModeParameter {
    val duration: Long
    val maximumPlayerCount: Int
    val minimumPlayerCount: Int

    @Serializable
    @SerialName("CarryTnt")
    data class ConfiguredCarryTNTParameter(
        override val duration: Long,
        override val maximumPlayerCount: Int,
        override val minimumPlayerCount: Int,
        val getTNTDuration: Long,
        val tntItemId: String,
    ) : dev.ryuzu.ryuzutechnicalmagic.api.core.configuration.data.game.mode.IConfiguredGameModeParameter

    @Serializable
    @SerialName("CaptureWool")
    data class ConfiguredCaptureWoolParameter(
        override val duration: Long,
        override val maximumPlayerCount: Int,
        override val minimumPlayerCount: Int,
        val captureDuration: Long,
    ) : dev.ryuzu.ryuzutechnicalmagic.api.core.configuration.data.game.mode.IConfiguredGameModeParameter
}