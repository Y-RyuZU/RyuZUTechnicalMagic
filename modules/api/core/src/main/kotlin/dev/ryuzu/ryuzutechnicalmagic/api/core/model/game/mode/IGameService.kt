package dev.ryuzu.ryuzutechnicalmagic.api.core.model.game.mode

import dev.ryuzu.ryuzutechnicalmagic.api.core.model.game.player.IGamePlayer

interface IGameService {
    val world: String
    fun end()
    fun joinGameMidway(player: dev.ryuzu.ryuzutechnicalmagic.api.core.model.entity.IPlayer)
    fun leaveGame(player: dev.ryuzu.ryuzutechnicalmagic.api.core.model.entity.IPlayer)
    fun getPhase(): Int
    fun getGamePlayer(player: dev.ryuzu.ryuzutechnicalmagic.api.core.model.entity.IPlayer): IGamePlayer
    fun isGamePlayer(player: dev.ryuzu.ryuzutechnicalmagic.api.core.model.entity.IPlayer): Boolean
    fun handlePlayerDeath(player: IGamePlayer, lastDamage: Double)
}