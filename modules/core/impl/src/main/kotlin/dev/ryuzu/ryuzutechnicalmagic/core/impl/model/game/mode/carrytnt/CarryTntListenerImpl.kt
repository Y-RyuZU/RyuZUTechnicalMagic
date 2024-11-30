package dev.ryuzu.ryuzutechnicalmagic.core.impl.model.game.mode.carrytnt

import dev.ryuzu.ryuzutechnicalmagic.api.core.event.data.PlayerQuitEvent
import dev.ryuzu.ryuzutechnicalmagic.api.core.event.data.block.PlayerBlockPlaceEvent
import dev.ryuzu.ryuzutechnicalmagic.api.core.event.data.click.PlayerRightClickBlockEvent
import dev.ryuzu.ryuzutechnicalmagic.api.core.event.data.damage.EntityDeathEvent
import dev.ryuzu.ryuzutechnicalmagic.api.core.event.data.item.PlayerDropEvent
import dev.ryuzu.ryuzutechnicalmagic.api.core.event.handler.EventHandler
import dev.ryuzu.ryuzutechnicalmagic.api.core.event.handler.IEventHandler
import dev.ryuzu.ryuzutechnicalmagic.api.core.model.entity.IPlayer
import dev.ryuzu.ryuzutechnicalmagic.api.core.model.game.mode.carrytnt.ICarryTntListener
import dev.ryuzu.ryuzutechnicalmagic.api.core.model.game.mode.carrytnt.ICarryTntService
import dev.ryuzu.ryuzutechnicalmagic.api.core.model.game.player.IGamePlayer.GamePlayer.ITeamGamePlayer.TeamGamePlayer.ICarryTntPlayer
import dev.ryuzu.ryuzutechnicalmagic.core.impl.model.game.mode.AbstractGameListener
import org.koin.core.annotation.Factory
import org.koin.core.annotation.InjectedParam

@Factory([ICarryTntListener::class])
class CarryTntListenerImpl(
    @InjectedParam private val gameService: ICarryTntService
) : AbstractGameListener(), ICarryTntListener, IEventHandler {

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