package dev.ryuzu.ryuzutechnicalmagiccore.model.game.mode.carrytnt

import dev.ryuzu.ryuzutechnicalmagiccore.event.data.PlayerQuitEvent
import dev.ryuzu.ryuzutechnicalmagiccore.event.data.block.PlayerBlockPlaceEvent
import dev.ryuzu.ryuzutechnicalmagiccore.event.data.click.PlayerRightClickBlockEvent
import dev.ryuzu.ryuzutechnicalmagiccore.event.data.damage.EntityDeathEvent
import dev.ryuzu.ryuzutechnicalmagiccore.event.data.item.PlayerDropEvent
import dev.ryuzu.ryuzutechnicalmagiccore.event.handler.EventHandler
import dev.ryuzu.ryuzutechnicalmagiccore.event.handler.IEventHandler
import dev.ryuzu.ryuzutechnicalmagiccore.model.entity.IPlayer
import dev.ryuzu.ryuzutechnicalmagiccore.model.game.mode.AbstractGameListener
import dev.ryuzu.ryuzutechnicalmagiccore.model.game.player.IGamePlayer.GamePlayer.ITeamGamePlayer.TeamGamePlayer.ICarryTntPlayer
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