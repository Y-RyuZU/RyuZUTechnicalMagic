package com.github.ryuzu.ryuzutechnicalmagiccore.minecraft.implementation.game.level

import com.github.ryuzu.ryuzutechnicalmagiccore.core.event.data.PlayerPortalReadyEvent
import com.github.ryuzu.ryuzutechnicalmagiccore.core.event.handler.EventHandler
import com.github.ryuzu.ryuzutechnicalmagiccore.core.event.handler.IEventHandler
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.game.level.AbstractLevelService
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.game.mode.IGameService
import org.koin.core.annotation.Single

@Single
class LevelServiceImpl(private val gameService: IGameService) : AbstractLevelService(), IEventHandler {
    @EventHandler
    fun onPortalReady(event: PlayerPortalReadyEvent) {
        if(!gameService.isGamePlayer(event.player)) return
        checkNorma(gameService.getGamePlayer(event.player))
    }
}