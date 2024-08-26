package com.github.ryuzu.ryuzutechnicalmagiccore.core.model.game.mode.carrytnt

import com.github.ryuzu.ryuzutechnicalmagiccore.core.event.data.PlayerQuitEvent
import com.github.ryuzu.ryuzutechnicalmagiccore.core.event.data.block.PlayerBlockPlaceEvent
import com.github.ryuzu.ryuzutechnicalmagiccore.core.event.data.click.PlayerRightClickBlockEvent
import com.github.ryuzu.ryuzutechnicalmagiccore.core.event.data.damage.EntityDeathEvent
import com.github.ryuzu.ryuzutechnicalmagiccore.core.event.data.item.PlayerDropEvent
import com.github.ryuzu.ryuzutechnicalmagiccore.core.event.handler.EventHandler
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.entity.IPlayer
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.game.mode.AbstractGameListener
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.game.player.IGamePlayer.GamePlayer.ITeamGamePlayer.TeamGamePlayer.ICarryTntPlayer
import org.koin.core.annotation.Factory
import org.koin.core.annotation.InjectedParam

@Factory([ICarryTntListener::class])
class CarryTntListenerImpl(
    @InjectedParam private val gameService: ICarryTntService
) : AbstractGameListener(), ICarryTntListener {

    @EventHandler
    override fun onClickTnt(event: PlayerRightClickBlockEvent) {
        if (event.offHand) return
        if (!gameService.isGamePlayer(event.player)) return
        val player = gameService.getGamePlayer(event.player)

        gameService.tryCarryTnt(event.location, player)
    }

    @EventHandler
    override fun onPlaceTnt(event: PlayerBlockPlaceEvent) {
        if (!gameService.isGamePlayer(event.player)) return
        val player: ICarryTntPlayer = gameService.getGamePlayer(event.player)
        if (!gameService.isHoldPlayer(player)) return
        if(!gameService.isTargetTNTPoint(event.location, player)) return

        gameService.placeTnt(event.location, player)
    }

    @EventHandler
    override fun onQuit(event: PlayerQuitEvent) {
        if (!gameService.isGamePlayer(event.player)) return

        gameService.leaveGame(event.player)
    }

    @EventHandler
    override fun onDeath(event: EntityDeathEvent) {
        if(event.entity !is IPlayer) return
        val player = event.entity as IPlayer
        if (!gameService.isGamePlayer(player)) return
        val gamePlayer: ICarryTntPlayer = gameService.getGamePlayer(player)
        if (!gameService.isHoldPlayer(gamePlayer)) return

        gameService.lostTNT(gamePlayer)
    }

    @EventHandler
    override fun onDrop(event: PlayerDropEvent) {
        if (!gameService.isGamePlayer(event.player)) return
        val player: ICarryTntPlayer = gameService.getGamePlayer(event.player)
        if (!gameService.isHoldPlayer(player)) return
        if(gameService.isTntItemId(event.item.id)) return

        event.isCancelled = true
    }
}