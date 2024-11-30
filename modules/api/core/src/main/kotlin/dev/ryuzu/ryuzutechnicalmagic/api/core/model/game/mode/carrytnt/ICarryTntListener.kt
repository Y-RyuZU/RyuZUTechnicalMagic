package dev.ryuzu.ryuzutechnicalmagic.api.core.model.game.mode.carrytnt

import dev.ryuzu.ryuzutechnicalmagic.api.core.event.data.PlayerQuitEvent
import dev.ryuzu.ryuzutechnicalmagic.api.core.event.data.block.PlayerBlockPlaceEvent
import dev.ryuzu.ryuzutechnicalmagic.api.core.event.data.click.PlayerRightClickBlockEvent
import dev.ryuzu.ryuzutechnicalmagic.api.core.event.data.damage.EntityDeathEvent
import dev.ryuzu.ryuzutechnicalmagic.api.core.event.data.item.PlayerDropEvent
import dev.ryuzu.ryuzutechnicalmagic.api.core.model.game.mode.IGameListener

interface ICarryTntListener : IGameListener {
    fun onClickTnt(event: PlayerRightClickBlockEvent)
    fun onPlaceTnt(event: PlayerBlockPlaceEvent)
    fun onQuit(event: PlayerQuitEvent)
    fun onDeath(event: EntityDeathEvent)
    fun onDrop(event: PlayerDropEvent)
}