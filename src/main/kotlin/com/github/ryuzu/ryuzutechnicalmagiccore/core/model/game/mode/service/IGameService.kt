package com.github.ryuzu.ryuzutechnicalmagiccore.core.model.game.mode.service

import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.game.mode.service.data.GameData
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.game.player.GamePlayer
import java.util.UUID

interface IGameService {
    val players: MutableSet<GamePlayer>
    val gameData: GameData

    fun start()
    fun end()
    fun canEnd(): Boolean
    fun tick()
    fun onPlayerDeath(player: GamePlayer)
    fun joinGameMidway(player: UUID)
    fun leaveGame(player: GamePlayer)
}