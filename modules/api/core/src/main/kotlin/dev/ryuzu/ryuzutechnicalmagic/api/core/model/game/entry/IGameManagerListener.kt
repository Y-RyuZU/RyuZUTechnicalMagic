package dev.ryuzu.ryuzutechnicalmagic.api.core.model.game.entry

import dev.ryuzu.ryuzutechnicalmagic.api.core.event.data.click.PlayerRightClickBlockEvent
import dev.ryuzu.ryuzutechnicalmagic.api.core.event.handler.IEventHandler

interface IGameManagerListener: IEventHandler {
    fun onInteractEntryGate(event: PlayerRightClickBlockEvent)
}