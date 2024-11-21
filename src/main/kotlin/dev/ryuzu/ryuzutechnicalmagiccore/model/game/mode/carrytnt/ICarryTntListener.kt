package dev.ryuzu.ryuzutechnicalmagiccore.model.game.mode.carrytnt

import dev.ryuzu.ryuzutechnicalmagiccore.event.data.PlayerQuitEvent
import dev.ryuzu.ryuzutechnicalmagiccore.event.data.block.PlayerBlockPlaceEvent
import dev.ryuzu.ryuzutechnicalmagiccore.event.data.click.PlayerRightClickBlockEvent
import dev.ryuzu.ryuzutechnicalmagiccore.event.data.damage.EntityDeathEvent
import dev.ryuzu.ryuzutechnicalmagiccore.event.data.item.PlayerDropEvent
import dev.ryuzu.ryuzutechnicalmagiccore.model.configuration.base.ConfiguredIntLocation
import dev.ryuzu.ryuzutechnicalmagiccore.model.game.mode.IGameListener
import dev.ryuzu.ryuzutechnicalmagiccore.model.game.mode.ITeamGameService
import dev.ryuzu.ryuzutechnicalmagiccore.model.game.player.IGamePlayer.GamePlayer.ITeamGamePlayer.TeamGamePlayer.ICarryTntPlayer

interface ICarryTntListener : IGameListener {
    fun onClickTnt(event: PlayerRightClickBlockEvent)
    fun onPlaceTnt(event: PlayerBlockPlaceEvent)
    fun onQuit(event: PlayerQuitEvent)
    fun onDeath(event: EntityDeathEvent)
    fun onDrop(event: PlayerDropEvent)
}