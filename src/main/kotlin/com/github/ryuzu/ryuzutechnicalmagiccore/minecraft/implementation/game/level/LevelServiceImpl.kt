package com.github.ryuzu.ryuzutechnicalmagiccore.minecraft.implementation.game.level

import com.github.ryuzu.ryuzutechnicalmagiccore.core.event.data.PlayerPortalReadyEvent
import com.github.ryuzu.ryuzutechnicalmagiccore.core.event.handler.EventHandler
import com.github.ryuzu.ryuzutechnicalmagiccore.core.event.handler.IEventHandler
import com.github.ryuzu.ryuzutechnicalmagiccore.core.event.publisher.IEventListenerCollector
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.game.level.AbstractLevelService
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.game.level.ILevelService
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.game.mode.IGameService
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.skill.service.ICoolTimeService
import org.koin.core.annotation.InjectedParam
import org.koin.core.annotation.Single
import org.koin.core.component.inject

@Single([ILevelService::class])
class LevelServiceImpl(@InjectedParam private val gameService: IGameService) : AbstractLevelService(), IEventHandler {
    private val eventListenerCollector: IEventListenerCollector by inject()

    init {
        eventListenerCollector.registerEventListener(this)
    }

    @EventHandler
    fun onPortalReady(event: PlayerPortalReadyEvent) {
        if(!gameService.isGamePlayer(event.player)) return
        checkNorma(gameService.getGamePlayer(event.player))
    }
}