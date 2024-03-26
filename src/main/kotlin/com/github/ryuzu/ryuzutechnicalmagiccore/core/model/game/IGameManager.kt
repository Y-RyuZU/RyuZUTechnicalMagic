package com.github.ryuzu.ryuzutechnicalmagiccore.core.model.game

import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.base.ConfiguredIntLocation
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.game.mode.GameMode
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.player.IPlayer
import org.koin.core.component.KoinComponent
import java.util.*

interface IGameManager : KoinComponent {
    fun isEntryGate(location: ConfiguredIntLocation): Boolean
    fun isEntryPlayer(location: ConfiguredIntLocation, player: IPlayer): Boolean
    fun hasEnoughEntrySpace(location: ConfiguredIntLocation, player: IPlayer): Boolean
    fun entryPlayer(location: ConfiguredIntLocation, player: IPlayer)
    fun exitPlayer(location: ConfiguredIntLocation, player: IPlayer)
    fun getGameMode(location: ConfiguredIntLocation): GameMode
    fun changeGameMode(location: ConfiguredIntLocation, gameMode: GameMode)
}