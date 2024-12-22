package dev.ryuzu.ryuzutechnicalmagic.api.game.data.mode

import kotlinx.serialization.Serializable

@Serializable
sealed interface IConfiguredGameModeParameter {
    val duration: Long
    val maximumPlayerCount: Int
    val minimumPlayerCount: Int

}