package com.github.ryuzu.ryuzutechnicalmagiccore.core.model.game.entry

import com.github.ryuzu.ryuzutechnicalmagiccore.core.event.data.click.PlayerRightClickBlockEvent
import com.github.ryuzu.ryuzutechnicalmagiccore.core.event.handler.IEventHandler

interface IGameManagerListener: IEventHandler {
    fun onInteractEntryGate(event: PlayerRightClickBlockEvent)
}