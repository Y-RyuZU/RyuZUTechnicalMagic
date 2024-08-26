package com.github.ryuzu.ryuzutechnicalmagiccore.core.model.game.mode

import com.github.ryuzu.ryuzutechnicalmagiccore.core.event.data.damage.EntityDeathEvent
import com.github.ryuzu.ryuzutechnicalmagiccore.core.event.handler.EventHandler
import com.github.ryuzu.ryuzutechnicalmagiccore.core.event.handler.IEventHandler
import com.github.ryuzu.ryuzutechnicalmagiccore.core.event.publisher.IEventListenerCollector
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.entity.IPlayer
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.game.player.IGamePlayer
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

abstract class AbstractGameListener() : IGameListener, IEventHandler, KoinComponent {
    private val gameService: IGameService by inject()
    private val eventListenerCollector: IEventListenerCollector by inject()

    init {
        eventListenerCollector.registerEventListener(this)
    }

    override fun unregister() {
        eventListenerCollector.unregisterEventListener(this)
    }

    @EventHandler(priority = 150)
    override fun onPlayerDeath(event: EntityDeathEvent) {
        if(event.entity !is IPlayer) return
        val player: IPlayer = event.entity as IPlayer
        if(!gameService.isGamePlayer(player)) return

        val gamePlayer: IGamePlayer = gameService.getGamePlayer(player)
        gameService.handlePlayerDeath(gamePlayer, event.lastDamage)

        event.shouldNotify = false

    }
}