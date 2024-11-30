package dev.ryuzu.ryuzutechnicalmagic.api.core.model.game.entry

import dev.ryuzu.ryuzutechnicalmagic.api.core.model.configuration.base.ConfiguredIntLocation
import dev.ryuzu.ryuzutechnicalmagic.api.core.model.game.mode.GameMode

interface IGameManagerService {
    fun isEntryGate(location: ConfiguredIntLocation): Boolean
    fun isEntryPlayer(location: ConfiguredIntLocation, player: dev.ryuzu.ryuzutechnicalmagic.api.core.model.entity.IPlayer): Boolean
    fun hasEnoughEntrySpace(location: ConfiguredIntLocation, player: dev.ryuzu.ryuzutechnicalmagic.api.core.model.entity.IPlayer): Boolean
    fun entryPlayer(location: ConfiguredIntLocation, player: dev.ryuzu.ryuzutechnicalmagic.api.core.model.entity.IPlayer)
    fun exitPlayer(location: ConfiguredIntLocation, player: dev.ryuzu.ryuzutechnicalmagic.api.core.model.entity.IPlayer)
    fun getGameMode(location: ConfiguredIntLocation): GameMode
    fun changeGameMode(location: ConfiguredIntLocation, gameMode: GameMode)
    fun openEntryGui(location: ConfiguredIntLocation, player: dev.ryuzu.ryuzutechnicalmagic.api.core.model.entity.IPlayer)
}