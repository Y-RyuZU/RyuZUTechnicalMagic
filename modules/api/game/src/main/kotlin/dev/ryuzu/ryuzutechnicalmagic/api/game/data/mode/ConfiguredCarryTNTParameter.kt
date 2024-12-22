package dev.ryuzu.ryuzutechnicalmagic.api.game.data.mode

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@SerialName("CarryTnt")
data class ConfiguredCarryTNTParameter(
    override val duration: Long,
    override val maximumPlayerCount: Int,
    override val minimumPlayerCount: Int,
    val getTNTDuration: Long,
    val tntItemId: String,
) : IConfiguredGameModeParameter