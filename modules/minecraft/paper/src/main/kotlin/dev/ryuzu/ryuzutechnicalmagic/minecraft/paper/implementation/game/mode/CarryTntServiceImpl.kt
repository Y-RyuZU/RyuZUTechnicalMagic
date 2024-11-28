package dev.ryuzu.ryuzutechnicalmagic.minecraft.paper.implementation.game.mode

import com.github.ryuzu.ryuzutechnicalmagiccore.core.event.data.PlayerQuitEvent
import com.github.ryuzu.ryuzutechnicalmagiccore.core.event.data.block.PlayerBlockPlaceEvent
import com.github.ryuzu.ryuzutechnicalmagiccore.core.event.data.click.PlayerRightClickBlockEvent
import com.github.ryuzu.ryuzutechnicalmagiccore.core.event.data.damage.EntityDeathEvent
import com.github.ryuzu.ryuzutechnicalmagiccore.core.event.data.item.PlayerDropEvent
import com.github.ryuzu.ryuzutechnicalmagiccore.core.event.handler.EventHandler
import com.github.ryuzu.ryuzutechnicalmagiccore.core.event.publisher.IEventListenerCollector
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.base.ConfiguredIntLocation
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.game.mode.ConfiguredGameMode
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.game.stage.ConfiguredStage
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.game.entry.IEntryGameService
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.game.mode.carrytnt.AbstractCarryTntService
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.game.mode.carrytnt.ICarryTntService
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.game.player.IGamePlayer
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.game.team.IGameTeam.AbstractScoreGameTeam.CarryTntTeam
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.entity.IPlayer
import dev.ryuzu.ryuzutechnicalmagic.minecraft.paper.util.ConfiguredUtility.Companion.toBlockLocation
import dev.ryuzu.ryuzutechnicalmagic.minecraft.paper.util.ConfiguredUtility.Companion.toMiddleLocation
import dev.ryuzu.ryuzutechnicalmagic.minecraft.paper.util.EntityUtility.Companion.toPlayer
import dev.ryuzu.ryuzutechnicalmagic.minecraft.paper.util.VectorUtility.Companion.getDegreeFrom3Points
import org.koin.core.annotation.Factory
import org.koin.core.annotation.InjectedParam
import org.koin.core.component.inject

@Factory([ICarryTntService::class])
class CarryTntServiceImpl(
    @InjectedParam world: String,
    @InjectedParam config: ConfiguredGameMode,
    @InjectedParam stage: ConfiguredStage,
    @InjectedParam entryService: IEntryGameService,
    @InjectedParam entryPlayers: Set<IPlayer>,
) : AbstractCarryTntService(world, config, stage, entryService, entryPlayers) {
    private val eventListenerCollector: IEventListenerCollector by inject()

    init {
        eventListenerCollector.registerEventListener(this)
    }

    override fun end() {
        super.end()
        eventListenerCollector.unregisterEventListener(this)
    }

    override fun checkTntAcquisitionStatus(
        tntLocation: ConfiguredIntLocation,
        player: IGamePlayer.GamePlayer.ITeamGamePlayer.TeamGamePlayer.ICarryTntPlayer
    ): Boolean {
        val player = player.toPlayer()
        return player.getTargetBlock(null, 5).location == tntLocation.toBlockLocation()
    }

    override fun getFirstTeamTntTargetPointDistance(): Double {
        val tntPoint = (gameData.holdPlayer?.toPlayer()?.location ?: tntBlockLocation?.toLocation(world)
            ?.toMiddleLocation())?.toVector()!!
        val firstTeamPoint =
            gameModeProperty.teamTNTLocations[teams.keys.first()]?.toLocation(world)?.toMiddleLocation()?.toVector()!!
        val secondTeamPoint =
            gameModeProperty.teamTNTLocations[teams.keys.last()]?.toLocation(world)?.toMiddleLocation()?.toVector()!!
        val firstTeamPointDistance = tntPoint.distance(firstTeamPoint)
        val secondTeamPointDistance = tntPoint.distance(secondTeamPoint)

        if (firstTeamPointDistance == 0.0)
            return 1.0
        else if (secondTeamPointDistance == 0.0)
            return 0.0

        val firstTeamPointDegree = firstTeamPoint.getDegreeFrom3Points(tntPoint, secondTeamPoint)
        val secondTeamPointDegree = secondTeamPoint.getDegreeFrom3Points(tntPoint, firstTeamPoint)

        if (firstTeamPointDegree > 90)
            return 1.0
        else if (secondTeamPointDegree > 90)
            return 0.0
        else
            return secondTeamPointDistance / (firstTeamPointDistance + secondTeamPointDistance)
    }

    @EventHandler
    fun onClickTnt(event: PlayerRightClickBlockEvent) {
        if (event.offHand) return
        if (!isGamePlayer(event.player)) return
        val player = getGamePlayer(event.player)

        tryCarryTnt(event.location, player)
    }

    @EventHandler
    fun onPlaceTnt(event: PlayerBlockPlaceEvent) {
        if (!isGamePlayer(event.player)) return
        val player = getGamePlayer(event.player)
        if (!isHoldPlayer(player)) return
        if(getEnemyPoint(player.team as CarryTntTeam) != event.location.vector) return

        placeTnt(event.location, player)
    }

    @EventHandler
    fun onQuit(event: PlayerQuitEvent) {
        if (!isGamePlayer(event.player)) return

        leaveGame(event.player)
    }

    @EventHandler
    fun onDeath(event: EntityDeathEvent) {
        if (!isGamePlayer(event.entity)) return
        val player = getGamePlayer(event.player)
        if (!isHoldPlayer(player)) return

        lostTNT(getGamePlayer(event.player))
    }

    @EventHandler
    fun onDrop(event: PlayerDropEvent) {
        if (!isGamePlayer(event.player)) return
        val player = getGamePlayer(event.player)
        if (!isHoldPlayer(player)) return
        if(event.item.id != gameModeParameter.tntItemId) return

        event.isCancelled = true
    }
}