package dev.ryuzu.ryuzutechnicalmagic.api.game.service.entry

import dev.ryuzu.ryuzutechnicalmagic.api.core.data.base.SerIntLocation
import dev.ryuzu.ryuzutechnicalmagic.api.game.service.mode.GameMode

interface IGameManagerService {
    fun isEntryGate(location: SerIntLocation): Boolean
    fun isEntryPlayer(location: SerIntLocation, player: dev.ryuzu.ryuzutechnicalmagic.api.core.model.entity.IPlayer): Boolean
    fun hasEnoughEntrySpace(location: SerIntLocation, player: dev.ryuzu.ryuzutechnicalmagic.api.core.model.entity.IPlayer): Boolean
    fun entryPlayer(location: SerIntLocation, player: dev.ryuzu.ryuzutechnicalmagic.api.core.model.entity.IPlayer)
    fun exitPlayer(location: SerIntLocation, player: dev.ryuzu.ryuzutechnicalmagic.api.core.model.entity.IPlayer)
    fun getGameMode(location: SerIntLocation): GameMode
    fun changeGameMode(location: SerIntLocation, gameMode: GameMode)
    fun openEntryGui(location: SerIntLocation, player: dev.ryuzu.ryuzutechnicalmagic.api.core.model.entity.IPlayer)
}