package dev.ryuzu.ryuzutechnicalmagicapi.model.game.mode.carrytnt

import dev.ryuzu.ryuzutechnicalmagicapi.event.data.PlayerQuitEvent
import dev.ryuzu.ryuzutechnicalmagicapi.event.data.block.PlayerBlockPlaceEvent
import dev.ryuzu.ryuzutechnicalmagicapi.event.data.click.PlayerRightClickBlockEvent
import dev.ryuzu.ryuzutechnicalmagicapi.event.data.damage.EntityDeathEvent
import dev.ryuzu.ryuzutechnicalmagicapi.event.data.item.PlayerDropEvent
import dev.ryuzu.ryuzutechnicalmagicapi.model.configuration.base.ConfiguredIntLocation
import dev.ryuzu.ryuzutechnicalmagicapi.model.game.mode.IGameListener
import dev.ryuzu.ryuzutechnicalmagicapi.model.game.mode.ITeamGameService
import dev.ryuzu.ryuzutechnicalmagicapi.model.game.player.IGamePlayer.GamePlayer.ITeamGamePlayer.TeamGamePlayer.ICarryTntPlayer

interface ICarryTntListener : IGameListener {
    fun onClickTnt(event: PlayerRightClickBlockEvent)
    fun onPlaceTnt(event: PlayerBlockPlaceEvent)
    fun onQuit(event: PlayerQuitEvent)
    fun onDeath(event: EntityDeathEvent)
    fun onDrop(event: PlayerDropEvent)
}