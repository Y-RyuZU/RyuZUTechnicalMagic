package com.github.ryuzu.ryuzutechnicalmagiccore.core.domain.model.game.active

import com.github.ryuzu.ryuzutechnicalmagiccore.core.domain.model.game.player.IGamePlayer

abstract class AbstractActiveGame : IActiveGame {

    override fun start() {
        // Start game logic
    }

    override fun end() {
        displayGameResults()
        returnPlayersToLobby()
    }

    override fun onPlayerLeave(player: IGamePlayer) {
        removePlayerFromGame(player)
        displayPlayerResults(player)
        returnPlayerToLobby(player)
    }

    abstract fun displayGameResults()
    abstract fun giveRewards()
    abstract fun returnPlayersToLobby()
    abstract fun removePlayerFromGame(player: IGamePlayer)
    abstract fun displayPlayerResults(player: IGamePlayer)
    abstract fun returnPlayerToLobby(player: IGamePlayer)
}