package dev.ryuzu.ryuzutechnicalmagic.core.impl.model.game.mode.carrytnt

import dev.ryuzu.ryuzutechnicalmagic.api.core.model.configuration.base.ConfiguredIntLocation
import dev.ryuzu.ryuzutechnicalmagic.api.core.configuration.data.base.ConfiguredIntVector
import dev.ryuzu.ryuzutechnicalmagic.api.core.model.configuration.game.mode.ConfiguredGameMode
import dev.ryuzu.ryuzutechnicalmagic.api.core.model.configuration.game.mode.IConfiguredGameModeParameter
import dev.ryuzu.ryuzutechnicalmagic.api.core.model.configuration.game.stage.ConfiguredStage
import dev.ryuzu.ryuzutechnicalmagic.api.core.configuration.data.game.stage.IConfiguredStageGameModeProperty
import dev.ryuzu.ryuzutechnicalmagic.api.core.model.configuration.game.team.ConfiguredTeam
import dev.ryuzu.ryuzutechnicalmagic.api.core.model.entity.IPlayer
import dev.ryuzu.ryuzutechnicalmagic.api.core.model.game.entry.IEntryGameService
import dev.ryuzu.ryuzutechnicalmagic.api.core.model.game.mode.IGameData
import dev.ryuzu.ryuzutechnicalmagic.api.core.model.game.mode.carrytnt.ICarryTntListener
import dev.ryuzu.ryuzutechnicalmagic.api.core.model.game.mode.carrytnt.ICarryTntService
import dev.ryuzu.ryuzutechnicalmagic.api.core.model.game.player.IGamePlayer.GamePlayer.ITeamGamePlayer.TeamGamePlayer.ICarryTntPlayer
import dev.ryuzu.ryuzutechnicalmagic.api.core.model.game.team.IGameTeam
import dev.ryuzu.ryuzutechnicalmagic.api.core.model.game.team.IGameTeam.IScoreGameTeam.CarryTntTeam
import dev.ryuzu.ryuzutechnicalmagic.api.core.model.scheduler.ISimpleScheduler
import dev.ryuzu.ryuzutechnicalmagic.api.core.model.scheduler.UpdatePeriod
import dev.ryuzu.ryuzutechnicalmagic.api.minecraft.adapter.bossbar.IBossBarFactory
import dev.ryuzu.ryuzutechnicalmagic.api.minecraft.adapter.bossbar.IBossBarObject
import dev.ryuzu.ryuzutechnicalmagic.core.impl.model.game.mode.AbstractTeamGameService
import org.koin.core.annotation.Factory
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import org.koin.core.parameter.parametersOf
import kotlin.math.max

@Factory([ICarryTntService::class])
class CarryTntServiceImpl(
    world: String,
    config: ConfiguredGameMode,
    stage: ConfiguredStage,
    entryService: IEntryGameService,
    entryPlayers: Set<IPlayer>,
) : ICarryTntService, AbstractTeamGameService(world, config, stage, entryService, entryPlayers), KoinComponent {
    override val gameData: IGameData.ITeamGameData.CarryTntData = IGameData.ITeamGameData.CarryTntData()
    override val gameModeParameter: IConfiguredGameModeParameter.ConfiguredCarryTNTParameter =
        config.parameter as IConfiguredGameModeParameter.ConfiguredCarryTNTParameter
    override val gameModeProperty: dev.ryuzu.ryuzutechnicalmagic.api.core.configuration.data.game.stage.IConfiguredStageGameModeProperty.ConfiguredStageCarryTNTProperty =
        stage.gameProperty as dev.ryuzu.ryuzutechnicalmagic.api.core.configuration.data.game.stage.IConfiguredStageGameModeProperty.ConfiguredStageCarryTNTProperty
    private var tntBlockLocation: ConfiguredIntVector? = gameModeProperty.tntSpawnPoint
    private var tryCarryTNTScheduler: ISimpleScheduler? = null

    @Suppress("UNCHECKED_CAST")
    private val carryTntTeam: LinkedHashMap<String, CarryTntTeam>
        get() = teams as LinkedHashMap<String, CarryTntTeam>

    private val listener: ICarryTntListener by inject { parametersOf(this) }
    private val bossBarFactory: IBossBarFactory by inject()
    private val bossBars: LinkedHashMap<CarryTntTeam, IBossBarObject> = linkedMapOf()

    override fun createPlayer(player: IPlayer): ICarryTntPlayer =
        ICarryTntPlayer.CarryTntPlayer(player, selectTeamAlgorithm(player) as CarryTntTeam)

    override fun getGamePlayer(player: IPlayer): ICarryTntPlayer =
        players.first { it.id == player.id } as ICarryTntPlayer

    override fun createGameTeam(config: ConfiguredTeam): dev.ryuzu.ryuzutechnicalmagic.core.impl.model.game.team.IGameTeam = CarryTntTeam(config)

    init {
        scheduler.whileSchedule { _, count ->
            val firstTeam = teams.values.first() as CarryTntTeam
            val secondTeam = teams.values.last() as CarryTntTeam
            val firstTeamTntTargetPointDistance = getFirstTeamTntTargetPointDistance()
            bossBars[firstTeam]?.progress(1 - firstTeamTntTargetPointDistance.toFloat())
            bossBars[secondTeam]?.progress(firstTeamTntTargetPointDistance.toFloat())


            if (gameData.holdPlayer?.team == firstTeam)
                firstTeam.score = max(firstTeam.score, ((1 - firstTeamTntTargetPointDistance - 0.5) * 200).toInt())
            else if (gameData.holdPlayer?.team == secondTeam)
                secondTeam.score = max(secondTeam.score, ((firstTeamTntTargetPointDistance - 0.5) * 200).toInt())

            if (count == gameModeParameter.duration * UpdatePeriod.MINUTE.getPeriod()) end()
        }.runSync()

        teams.values.forEach {
            bossBars[it as CarryTntTeam]?.addPlayers(it.players)
        }
        scoreboard.addPlayers(players)

        blockService.setBlock(tntBlockLocation!!.toLocation(world), "TNT")
    }

    override fun end() {
        bossBars.values.forEach { it.destroy() }
        scoreboard.destroy()
        listener.unregister()
        super.end()
    }

    override fun joinGameMidway(player: IPlayer) {
        super.joinGameMidway(player)
        val gamePlayer = getGamePlayer(player)
        bossBars[gamePlayer.team]?.addPlayers(player)
        scoreboard.addPlayers(player)
    }

    override fun leaveGame(player: IPlayer) {
        val gamePlayer = getGamePlayer(player)
        if (gameData.holdPlayer == gamePlayer)
            lostTNT(gameData.holdPlayer!!)
        bossBars[gamePlayer.team]?.removePlayers(player)
        scoreboard.removePlayers(player)
        super.leaveGame(player)
    }

    override fun tryCarryTnt(location: ConfiguredIntLocation, player: ICarryTntPlayer) {
        if (tntBlockLocation != location.vector) return
        if (tryCarryTNTScheduler != null) return
        tryCarryTNTScheduler =
            schedulerFactory.createSimpleScheduler().schedule(0, gameModeParameter.getTNTDuration) { scheduler, _ ->
                if (!checkTntAcquisitionStatus(location, player)) scheduler.cancel()
            }.schedule(0, gameModeParameter.getTNTDuration, UpdatePeriod.SECOND.getCondition()) { _, _ ->
                player.sendTitle(null, "CARRYING TNT!")
                effectService.playEffect(config.effect, "CarryTnt", player)
                itemManager.giveItem(gameModeParameter.tntItemId, player)
            }.finally { tryCarryTNTScheduler = null }.end { getTnt(player) }.runSync()
    }

    override fun lostTNT(player: ICarryTntPlayer) {
        gameData.holdPlayer = null
        tntBlockLocation = player.getIntLocation().vector
        blockService.setBlock(tntBlockLocation!!.toLocation(world), "TNT")
        titleService.sendTitle(null, "LOST TNT!", player.team.players)
        effectService.playEffect(config.effect, "LostTnt", player.team.players)
        itemManager.removeItem(gameModeParameter.tntItemId, player)
        bossBars.values.forEach { it.color("WHITE") }
    }

    override fun placeTnt(location: ConfiguredIntLocation, player: ICarryTntPlayer) {
        blockService.setBlock(location.vector.toLocation(world), "TNT")
        titleService.sendTitle(null, "PLACED TNT!", player.team.players)
        effectService.playEffect(config.effect, "PlaceTNT", players)
        end()
    }

    override fun isHoldPlayer(player: ICarryTntPlayer): Boolean =
        gameData.holdPlayer == player

    private fun isTNTPoint(location: ConfiguredIntLocation): Boolean =
        gameModeProperty.tntSpawnPoint == location.vector

    private fun isTNTExplodePoint(location: ConfiguredIntLocation): Boolean =
        gameModeProperty.teamTNTLocations.containsValue(location.vector)

    override fun isTargetTNTPoint(location: ConfiguredIntLocation, player: ICarryTntPlayer): Boolean =
        isTNTExplodePoint(location) && (getEnemyPoint(player.team) != location.vector)

    override fun isTntItemId(itemId: String): Boolean = gameModeParameter.tntItemId == itemId

    private fun getTnt(player: ICarryTntPlayer) {
        gameData.holdPlayer = player
        blockService.setBlock(tntBlockLocation!!.toLocation(world), "AIR")
        tntBlockLocation = null
        bossBars.values.forEach { it.color(player.team.property.id.uppercase()) }
    }

    private fun getEnemyPoint(team: CarryTntTeam): ConfiguredIntVector {
        val enemy = teams.values.first { it != team } as CarryTntTeam
        return gameModeProperty.teamTNTLocations[enemy.property.id]!!
    }

    private fun checkTntAcquisitionStatus(
        tntLocation: ConfiguredIntLocation,
        player: ICarryTntPlayer
    ): Boolean {
        val player = player.toPlayer()
        return player.getTargetBlock(null, 5).location == tntLocation.toBlockLocation()
    }

    private fun getFirstTeamTntTargetPointDistance(): Double {
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


    override fun createBossBar() {
        teams.values.forEach {
            bossBars[it as CarryTntTeam] = bossBarFactory.createBossBarService().createBossBar(
                stage.display.bossBar,
                placeholders,
                UpdatePeriod.TICK
            )
            bossBars[it]!!.progress(0.5F)
        }
    }

    override val placeholders: Map<String, () -> String> = buildMap {
        putAll(super.placeholders)
        teams.entries.forEachIndexed { index, entry ->
//            put("%team1_tnt_distance%") { getFirstTeamTntTargetPointDistance().toString() }
//            put("%team2_tnt_distance%") { (100 - getFirstTeamTntTargetPointDistance()).toString() }
            put("%tnt_holder%") { gameData.holdPlayer?.getName() ?: "None" }
        }
    }
}