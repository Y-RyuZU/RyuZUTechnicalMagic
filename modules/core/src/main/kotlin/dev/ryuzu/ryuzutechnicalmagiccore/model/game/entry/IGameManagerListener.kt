package dev.ryuzu.ryuzutechnicalmagiccore.model.game.entry

import dev.ryuzu.ryuzutechnicalmagiccore.event.data.click.PlayerRightClickBlockEvent
import dev.ryuzu.ryuzutechnicalmagiccore.event.handler.IEventHandler

interface IGameManagerListener: IEventHandler {
    fun onInteractEntryGate(event: PlayerRightClickBlockEvent)
}