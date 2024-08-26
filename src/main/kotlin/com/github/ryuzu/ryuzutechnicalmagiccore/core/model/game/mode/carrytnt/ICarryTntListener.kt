package com.github.ryuzu.ryuzutechnicalmagiccore.core.model.game.mode.carrytnt

import com.github.ryuzu.ryuzutechnicalmagiccore.core.event.data.PlayerQuitEvent
import com.github.ryuzu.ryuzutechnicalmagiccore.core.event.data.block.PlayerBlockPlaceEvent
import com.github.ryuzu.ryuzutechnicalmagiccore.core.event.data.click.PlayerRightClickBlockEvent
import com.github.ryuzu.ryuzutechnicalmagiccore.core.event.data.damage.EntityDeathEvent
import com.github.ryuzu.ryuzutechnicalmagiccore.core.event.data.item.PlayerDropEvent
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.base.ConfiguredIntLocation
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.game.mode.IGameListener
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.game.mode.ITeamGameService
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.game.player.IGamePlayer.GamePlayer.ITeamGamePlayer.TeamGamePlayer.ICarryTntPlayer

interface ICarryTntListener : IGameListener {
    fun onClickTnt(event: PlayerRightClickBlockEvent)
    fun onPlaceTnt(event: PlayerBlockPlaceEvent)
    fun onQuit(event: PlayerQuitEvent)
    fun onDeath(event: EntityDeathEvent)
    fun onDrop(event: PlayerDropEvent)
}