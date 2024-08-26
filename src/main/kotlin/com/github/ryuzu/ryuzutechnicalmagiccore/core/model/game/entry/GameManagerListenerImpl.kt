package com.github.ryuzu.ryuzutechnicalmagiccore.core.model.game.entry

import com.github.ryuzu.ryuzutechnicalmagiccore.core.event.data.click.PlayerRightClickBlockEvent
import com.github.ryuzu.ryuzutechnicalmagiccore.core.event.handler.EventHandler
import com.github.ryuzu.ryuzutechnicalmagiccore.core.event.publisher.IEventListenerCollector
import org.koin.core.annotation.Single
import org.koin.core.component.inject

@Single([IGameManagerListener::class], true)
class GameManagerListenerImpl : IGameManagerListener {
    private val eventListenerCollector: IEventListenerCollector by inject()
    private val gameManager: IGameManagerService by inject()

    init {
        eventListenerCollector.registerEventListener(this)
    }

    @EventHandler
    override fun onInteractEntryGate(event: PlayerRightClickBlockEvent) {
        if (event.offHand) return
        if (!gameManager.isEntryGate(event.location)) return

        val player = event.player
        val location = event.location

        if (player.isSneaking()) {
            gameManager.openEntryGui(location, player)
        } else {
            if (gameManager.isEntryPlayer(location, player))
                gameManager.exitPlayer(location, player)
            else if (gameManager.hasEnoughEntrySpace(location, player))
                gameManager.entryPlayer(location, player)
        }
    }
}