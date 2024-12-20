package dev.ryuzu.ryuzutechnicalmagic.core.impl.model.game.mode

import dev.ryuzu.ryuzutechnicalmagic.api.core.event.data.damage.EntityDeathEvent
import dev.ryuzu.ryuzutechnicalmagic.api.core.event.handler.EventHandler
import dev.ryuzu.ryuzutechnicalmagic.api.core.event.handler.IEventHandler
import dev.ryuzu.ryuzutechnicalmagic.api.core.event.publisher.IEventListenerCollector
import dev.ryuzu.ryuzutechnicalmagic.api.core.model.entity.IPlayer
import dev.ryuzu.ryuzutechnicalmagic.api.core.model.game.mode.IGameListener
import dev.ryuzu.ryuzutechnicalmagic.api.core.model.game.mode.IGameService
import dev.ryuzu.ryuzutechnicalmagic.api.core.model.game.player.IGamePlayer
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

abstract class AbstractGameListener : IGameListener, IEventHandler, KoinComponent {
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