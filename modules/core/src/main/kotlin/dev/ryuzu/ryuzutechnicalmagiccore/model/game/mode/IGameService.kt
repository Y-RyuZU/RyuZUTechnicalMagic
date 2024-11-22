package dev.ryuzu.ryuzutechnicalmagiccore.model.game.mode

import dev.ryuzu.ryuzutechnicalmagiccore.model.game.player.IGamePlayer
import dev.ryuzu.ryuzutechnicalmagiccore.model.entity.IPlayer

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