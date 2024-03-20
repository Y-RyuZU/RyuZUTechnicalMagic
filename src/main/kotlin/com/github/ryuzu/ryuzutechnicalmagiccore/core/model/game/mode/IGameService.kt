package com.github.ryuzu.ryuzutechnicalmagiccore.core.model.game.mode

import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.game.player.IGamePlayer
import org.koin.core.component.KoinComponent
import java.util.UUID

interface IGameService : KoinComponent {
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