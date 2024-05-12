package com.github.ryuzu.ryuzutechnicalmagiccore.core.model.game.mode

import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.game.player.IGamePlayer
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.entity.IPlayer

interface IGameService {
    val world: String

    fun start()
    fun end()
    fun joinGameMidway(player: IPlayer)
    fun leaveGame(player: IPlayer)
    fun getPhase(): Int
    fun getGamePlayer(player: IPlayer): IGamePlayer
    fun isGamePlayer(player: IPlayer): Boolean
}