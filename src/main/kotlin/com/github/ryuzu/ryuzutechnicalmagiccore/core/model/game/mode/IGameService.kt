package com.github.ryuzu.ryuzutechnicalmagiccore.core.model.game.mode

import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.game.player.IGamePlayer
import java.util.UUID

interface IGameService {
    val gameData: GameData
    val world: String

    fun start()
    fun end()
    fun canEnd(): Boolean
    fun second()
    fun onPlayerDeath(player: IGamePlayer)
    fun joinGameMidway(player: UUID)
    fun leaveGame(player: IGamePlayer)
    fun getPhase(): Int
}