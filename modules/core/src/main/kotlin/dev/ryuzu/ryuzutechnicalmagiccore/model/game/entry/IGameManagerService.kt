package dev.ryuzu.ryuzutechnicalmagiccore.model.game.entry

import dev.ryuzu.ryuzutechnicalmagiccore.model.configuration.base.ConfiguredIntLocation
import dev.ryuzu.ryuzutechnicalmagiccore.model.game.mode.GameMode
import dev.ryuzu.ryuzutechnicalmagiccore.model.entity.IPlayer
import org.koin.core.component.KoinComponent

interface IGameManagerService : KoinComponent {
    fun isEntryGate(location: ConfiguredIntLocation): Boolean
    fun isEntryPlayer(location: ConfiguredIntLocation, player: IPlayer): Boolean
    fun hasEnoughEntrySpace(location: ConfiguredIntLocation, player: IPlayer): Boolean
    fun entryPlayer(location: ConfiguredIntLocation, player: IPlayer)
    fun exitPlayer(location: ConfiguredIntLocation, player: IPlayer)
    fun getGameMode(location: ConfiguredIntLocation): GameMode
    fun changeGameMode(location: ConfiguredIntLocation, gameMode: GameMode)
    fun openEntryGui(location: ConfiguredIntLocation, player: IPlayer)
}