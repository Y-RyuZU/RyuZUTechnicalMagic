package dev.ryuzu.ryuzutechnicalmagic.api.game.data.mode

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@SerialName("CaptureWool")
data class ConfiguredCaptureWoolParameter(
    override val duration: Long,
    override val maximumPlayerCount: Int,
    override val minimumPlayerCount: Int,
    val captureDuration: Long,
) : IConfiguredGameModeParameter