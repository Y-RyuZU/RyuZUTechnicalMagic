package dev.ryuzu.ryuzutechnicalmagic.core.impl.event.handler

import dev.ryuzu.ryuzutechnicalmagic.api.core.event.data.damage.IEntityDeathEvent
import dev.ryuzu.ryuzutechnicalmagic.api.core.event.handler.IEventHandler
import dev.ryuzu.ryuzutechnicalmagic.api.core.event.publisher.IEventListenerCollector
import dev.ryuzu.ryuzutechnicalmagic.api.core.model.configuration.general.ConfiguredGeneralParameter
import dev.ryuzu.ryuzutechnicalmagic.api.core.model.entity.IPlayer
import org.koin.core.annotation.Single
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

@Single(createdAtStart = true)
class PlayerDeathEventHandler : IEventHandler, KoinComponent {
    private val config: ConfiguredGeneralParameter by inject()
    private val eventListenerCollector: IEventListenerCollector by inject()

    init {
        eventListenerCollector.registerEventListener(this)
    }

    @EventHandler(priority = 200)
    fun handle(event: IEntityDeathEvent) {
        if(event.entity !is IPlayer) return
        val player = event.entity as IPlayer
        player.teleport(config.respawnParameter.defaultRespawnPoint)
    }
}