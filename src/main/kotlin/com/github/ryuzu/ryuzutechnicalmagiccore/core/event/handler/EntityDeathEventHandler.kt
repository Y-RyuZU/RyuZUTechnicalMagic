package com.github.ryuzu.ryuzutechnicalmagiccore.core.event.handler

import com.github.ryuzu.ryuzutechnicalmagiccore.core.event.data.damage.EntityDeathEvent
import com.github.ryuzu.ryuzutechnicalmagiccore.core.event.data.damage.PlayerDeathEvent
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.game.general.ConfiguredGeneralParameter
import com.github.ryuzu.ryuzutechnicalmagiccore.core.util.wrapper.teleport.ITeleportService
import org.koin.core.component.inject

class EntityDeathEventHandler : IEventHandler {
    private val teleportService: ITeleportService by inject()
    private val config: ConfiguredGeneralParameter by inject()

    @EventHandler(priority = 200)
    fun handle(event: PlayerDeathEvent) {
        teleportService.teleport(config.respawnParameter.defaultRespawnPoint, event.player)
    }
}