package dev.ryuzu.ryuzutechnicalmagicapi.model.game.entry

import dev.ryuzu.ryuzutechnicalmagicapi.event.data.click.PlayerRightClickBlockEvent
import dev.ryuzu.ryuzutechnicalmagicapi.event.handler.IEventHandler

interface IGameManagerListener: IEventHandler {
    fun onInteractEntryGate(event: PlayerRightClickBlockEvent)
}