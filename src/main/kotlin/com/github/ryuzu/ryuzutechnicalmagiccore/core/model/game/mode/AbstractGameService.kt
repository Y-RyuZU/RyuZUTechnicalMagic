package com.github.ryuzu.ryuzutechnicalmagiccore.core.model.game.mode

import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.game.player.IGamePlayer
import java.util.*

abstract class AbstractGameService(
    protected open val players: MutableSet<IGamePlayer>
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

    override fun leaveGame(player: IGamePlayer) {
        removePlayerFromGame(player)
        sendPlayerResultMessage(player)
        returnPlayerToLobby(player)
    }

    override fun second() {
        renderGameStatus()
    }

    protected abstract fun teleportPlayersToGame()
    protected abstract fun sendGameStartMessage()
    protected abstract fun playGameStartSound()
    protected abstract fun sendPlayerResultMessage(player: IGamePlayer)

    protected abstract fun giveRewards()
    protected abstract fun returnPlayersToLobby()
    protected abstract fun removePlayerFromGame(player: IGamePlayer)
    protected abstract fun returnPlayerToLobby(player: IGamePlayer)
    protected abstract fun sendGameResultMessage()

    protected abstract fun renderGameStatus()
}