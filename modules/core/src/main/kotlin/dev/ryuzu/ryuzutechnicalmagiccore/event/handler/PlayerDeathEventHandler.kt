package dev.ryuzu.ryuzutechnicalmagiccore.event.handler

import dev.ryuzu.ryuzutechnicalmagiccore.event.data.damage.EntityDeathEvent
import dev.ryuzu.ryuzutechnicalmagiccore.event.publisher.IEventListenerCollector
import dev.ryuzu.ryuzutechnicalmagiccore.model.configuration.general.ConfiguredGeneralParameter
import dev.ryuzu.ryuzutechnicalmagiccore.model.entity.IPlayer
import dev.ryuzu.ryuzutechnicalmagiccore.util.wrapper.teleport.ITeleportService
import org.koin.core.annotation.Single
import org.koin.core.component.inject

@Single(createdAtStart = true)
class PlayerDeathEventHandler : IEventHandler {
    private val config: ConfiguredGeneralParameter by inject()
    private val eventListenerCollector: IEventListenerCollector by inject()

    init {
        eventListenerCollector.registerEventListener(this)
    }

    @EventHandler(priority = 200)
    fun handle(event: EntityDeathEvent) {
        if(event.entity !is IPlayer) return
        val player = event.entity as IPlayer
        player.teleport(config.respawnParameter.defaultRespawnPoint)
    }
}