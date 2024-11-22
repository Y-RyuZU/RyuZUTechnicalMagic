package dev.ryuzu.ryuzutechnicalmagicapi.model.game.entry

import dev.ryuzu.ryuzutechnicalmagicapi.model.configuration.base.ConfiguredIntLocation
import dev.ryuzu.ryuzutechnicalmagicapi.model.game.mode.GameMode
import dev.ryuzu.ryuzutechnicalmagicapi.model.entity.IPlayer

interface IGameManagerService {
    fun isEntryGate(location: ConfiguredIntLocation): Boolean
    fun isEntryPlayer(location: ConfiguredIntLocation, player: IPlayer): Boolean
    fun hasEnoughEntrySpace(location: ConfiguredIntLocation, player: IPlayer): Boolean
    fun entryPlayer(location: ConfiguredIntLocation, player: IPlayer)
    fun exitPlayer(location: ConfiguredIntLocation, player: IPlayer)
    fun getGameMode(location: ConfiguredIntLocation): GameMode
    fun changeGameMode(location: ConfiguredIntLocation, gameMode: GameMode)
    fun openEntryGui(location: ConfiguredIntLocation, player: IPlayer)
}