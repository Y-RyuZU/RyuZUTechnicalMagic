package com.github.ryuzu.ryuzutechnicalmagiccore.minecraft.implementation.game.mode

import com.github.ryuzu.ryuzutechnicalmagiccore.core.event.data.PlayerQuitEvent
import com.github.ryuzu.ryuzutechnicalmagiccore.core.event.data.PlayerRightClickBlockEvent
import com.github.ryuzu.ryuzutechnicalmagiccore.core.event.handler.EventHandler
import com.github.ryuzu.ryuzutechnicalmagiccore.core.event.handler.IEventHandler
import com.github.ryuzu.ryuzutechnicalmagiccore.core.event.publisher.IEventListenerCollector
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.base.ConfiguredIntLocation
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.game.stage.ConfiguredStage
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.game.entry.IEntryGameService
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.game.mode.carrytnt.AbstractCarryTntService
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.game.player.IGamePlayer
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.player.IPlayer
import com.github.ryuzu.ryuzutechnicalmagiccore.minecraft.util.ConfiguredUtility.Companion.toBlockLocation
import com.github.ryuzu.ryuzutechnicalmagiccore.minecraft.util.ConfiguredUtility.Companion.toMiddleLocation
import com.github.ryuzu.ryuzutechnicalmagiccore.minecraft.util.PlayerUtility.Companion.toPlayer
import com.github.ryuzu.ryuzutechnicalmagiccore.minecraft.util.VectorUtility.Companion.getDegreeFrom3Points
import org.koin.core.component.inject
import java.util.*

class CarryTntServiceImpl(
    world: String,
    stage: ConfiguredStage,
    entryService: IEntryGameService,
    entryPlayers: Set<IPlayer>,
) : AbstractCarryTntService(world, stage, entryService, entryPlayers), IEventHandler {
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

    override fun getFirstTeamTntTargetPointDistance(): Int {
        val tntPoint = (gameData.holdPlayer?.toPlayer()?.location ?: tntBlockLocation?.toLocation(world)
            ?.toMiddleLocation())?.toVector()!!
        val ownPoint =
            gameModeProperty.teamTNTLocations[teams.keys.first()]?.toLocation(world)?.toMiddleLocation()?.toVector()!!
        val targetPoint =
            gameModeProperty.teamTNTLocations[teams.keys.last()]?.toLocation(world)?.toMiddleLocation()?.toVector()!!
        val ownPointDistance = tntPoint.distance(ownPoint)
        val targetPointDistance = tntPoint.distance(targetPoint)

        if(ownPointDistance == 0.0)
            return 100
        else if(targetPointDistance == 0.0)
            return 0

        val targetPointDegree = targetPoint.getDegreeFrom3Points(ownPoint, tntPoint)
        val ownPointDegree = ownPoint.getDegreeFrom3Points(targetPoint, tntPoint)

        if (ownPointDegree > 90)
            return 100
        else if (targetPointDegree > 90)
            return 0
        else
            return ((targetPointDistance / (ownPointDistance + targetPointDistance)) * 100).toInt()
    }

    @EventHandler
    fun onClickTnt(event: PlayerRightClickBlockEvent) {
        if(!isGamePlayer(event.player)) return
        val player = getGamePlayer(event.player)
        tryCarryTNT(event.block, player)
    }

    @EventHandler
    fun onQuit(event: PlayerQuitEvent) {
        if(!isGamePlayer(event.player)) return
        leaveGame(event.player)
    }
}