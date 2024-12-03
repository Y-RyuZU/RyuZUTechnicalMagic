package dev.ryuzu.ryuzutechnicalmagic.api.core.model.game.mode

import dev.ryuzu.ryuzutechnicalmagic.api.core.model.entity.IPlayer
import dev.ryuzu.ryuzutechnicalmagic.api.core.model.game.player.IGamePlayer

interface IGameService {
    val world: String
    fun end()
    fun joinGameMidway(player: IPlayer)
    fun leaveGame(player: IPlayer)
    fun getPhase(): Int
    fun getGamePlayer(player: IPlayer): IGamePlayer
    fun isGamePlayer(player: IPlayer): Boolean
    fun handlePlayerDeath(player: IGamePlayer, lastDamage: Double)
}