package com.github.ryuzu.ryuzutechnicalmagiccore.core.model.game.mode.service

import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.game.player.GamePlayer
import java.util.*

abstract class AbstractGameService(
    override val players: MutableSet<GamePlayer>
) : IGameService {
    override fun start() {
        teleportPlayersToGame()
        sendGameStartMessage()
        playGameStartSound()
    }

    override fun end() {
        sendGameResultMessage()
        returnPlayersToLobby()
        giveRewards()
    }

    override fun joinGameMidway(player: UUID) {
        teleportPlayersToGame()
        sendGameStartMessage()
        playGameStartSound()
    }

    override fun leaveGame(player: GamePlayer) {
        removePlayerFromGame(player)
        sendPlayerResultMessage(player)
        returnPlayerToLobby(player)
    }

    override fun tick() {
        renderGameStatus()
    }

    protected abstract fun teleportPlayersToGame()
    protected abstract fun sendGameStartMessage()
    protected abstract fun playGameStartSound()
    protected abstract fun sendPlayerResultMessage(player: GamePlayer)

    protected abstract fun giveRewards()
    protected abstract fun returnPlayersToLobby()
    protected abstract fun removePlayerFromGame(player: GamePlayer)
    protected abstract fun returnPlayerToLobby(player: GamePlayer)
    protected abstract fun sendGameResultMessage()

    protected abstract fun renderGameStatus()
}