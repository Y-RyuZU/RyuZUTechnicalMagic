package com.github.ryuzu.ryuzutechnicalmagiccore.core.event.handler

import com.github.ryuzu.ryuzutechnicalmagiccore.core.event.data.damage.EntityDeathEvent
import com.github.ryuzu.ryuzutechnicalmagiccore.core.event.publisher.IEventListenerCollector
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.general.ConfiguredGeneralParameter
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.entity.IPlayer
import com.github.ryuzu.ryuzutechnicalmagiccore.core.util.wrapper.teleport.ITeleportService
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