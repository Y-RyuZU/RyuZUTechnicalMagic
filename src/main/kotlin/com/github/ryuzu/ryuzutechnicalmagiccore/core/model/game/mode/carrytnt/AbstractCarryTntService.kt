package com.github.ryuzu.ryuzutechnicalmagiccore.core.model.game.mode.carrytnt

import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.base.ConfiguredIntVector
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.base.ConfiguredIntLocation
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.game.mode.ConfiguredGameMode
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.game.mode.IConfiguredGameModeParameter
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.game.stage.ConfiguredStage
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.game.player.IGamePlayer.GamePlayer.ITeamGamePlayer.TeamGamePlayer.ICarryTntPlayer
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.game.stage.IConfiguredStageGameModeProperty
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.game.team.ConfiguredTeam
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.game.entry.IEntryGameService
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.game.mode.AbstractTeamGameService
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.game.mode.IGameData
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.game.player.IGamePlayer
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.game.team.IGameTeam
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.game.team.IGameTeam.AbstractScoreGameTeam.CarryTntTeam
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.player.IPlayer
import com.github.ryuzu.ryuzutechnicalmagiccore.core.util.scheduler.ISimpleScheduler
import com.github.ryuzu.ryuzutechnicalmagiccore.core.util.scheduler.UpdatePeriod
import com.github.ryuzu.ryuzutechnicalmagiccore.core.util.wrapper.bossbar.BossBarFactory
import com.github.ryuzu.ryuzutechnicalmagiccore.core.util.wrapper.bossbar.IBossBarService
import com.github.ryuzu.ryuzutechnicalmagiccore.core.util.wrapper.scoreboard.IScoreboardService
import com.github.ryuzu.ryuzutechnicalmagiccore.core.util.wrapper.scoreboard.ScoreboardFactory
import org.koin.core.component.inject
import kotlin.collections.LinkedHashMap
import kotlin.math.max

abstract class AbstractCarryTntService(
    world: String,
    config: ConfiguredGameMode,
    stage: ConfiguredStage,
    entryService: IEntryGameService,
    entryPlayers: Set<IPlayer>,
) : ICarryTntService, AbstractTeamGameService(world, config, stage, entryService, entryPlayers) {
    override val gameData: IGameData.ITeamGameData.CarryTntData = IGameData.ITeamGameData.CarryTntData()
    override val gameModeParameter: IConfiguredGameModeParameter.ConfiguredCarryTNTParameter =
        config.parameter as IConfiguredGameModeParameter.ConfiguredCarryTNTParameter
    final override val gameModeProperty: IConfiguredStageGameModeProperty.ConfiguredStageCarryTNTProperty =
        stage.gameProperty as IConfiguredStageGameModeProperty.ConfiguredStageCarryTNTProperty
    protected var tntBlockLocation: ConfiguredIntVector? = gameModeProperty.tntSpawnPoint
    private var tryCarryTNTScheduler: ISimpleScheduler? = null

    private val scoreboardFactory: ScoreboardFactory by inject()
    private lateinit var scoreboard: IScoreboardService
    private val bossBarFactory: BossBarFactory by inject()
    private val bossBars: LinkedHashMap<CarryTntTeam, IBossBarService> = linkedMapOf()

    override fun createPlayer(player: IPlayer): IGamePlayer = ICarryTntPlayer.CarryTntPlayer(player)
    override fun getGamePlayer(player: IPlayer): ICarryTntPlayer =
        players.first { it.id == player.id } as ICarryTntPlayer

    override fun createGameTeam(config: ConfiguredTeam): IGameTeam = CarryTntTeam(config)

    override fun start() {
        super.start()
        scheduler.whileSchedule { _, count ->
            val firstTeam = teams.values.first() as CarryTntTeam
            val secondTeam = teams.values.last() as CarryTntTeam
            val firstTeamTntTargetPointDistance = getFirstTeamTntTargetPointDistance()
            bossBars[firstTeam]?.progress(1 - firstTeamTntTargetPointDistance.toFloat())
            bossBars[secondTeam]?.progress(firstTeamTntTargetPointDistance.toFloat())


            if (gameData.holdPlayer?.team == firstTeam)
                firstTeam.score = max(firstTeam.score, ((1 - firstTeamTntTargetPointDistance - 0.5) * 200).toInt())
            else if(gameData.holdPlayer?.team == secondTeam)
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
            schedulerFactory.createScheduler().schedule(0, gameModeParameter.getTNTDuration) { scheduler, _ ->
                if (!checkTntAcquisitionStatus(location, player)) scheduler.cancel()
            }.schedule(0, gameModeParameter.getTNTDuration, UpdatePeriod.SECOND.getCondition()) { _, _ ->
                player.sendTitle(null, "CARRYING TNT!")
                effectService.playEffect(config.effect, "CarryTnt", player)
            }.finally { tryCarryTNTScheduler = null }.end { getTnt(player) }.runSync()
    }

    override fun lostTNT(player: ICarryTntPlayer) {
        gameData.holdPlayer = null
        tntBlockLocation = player.getIntLocation().vector
        blockService.setBlock(tntBlockLocation!!.toLocation(world), "TNT")
        titleService.sendTitle(null, "LOST TNT!", player.team.players)
        effectService.playEffect(config.effect, "LostTnt", player.team.players)
        bossBars.values.forEach { it.color("WHITE") }
    }

    override fun placeTnt(location: ConfiguredIntLocation, player: ICarryTntPlayer) {
        if(getEnemyPoint(player.team as CarryTntTeam) != location.vector) return
        blockService.setBlock(location.vector.toLocation(world), "TNT")
        titleService.sendTitle(null, "PLACED TNT!", player.team.players)
        effectService.playEffect(config.effect, "PlaceTNT", players)
        end()
    }

    override fun isHoldPlayer(player: ICarryTntPlayer): Boolean =
        gameData.holdPlayer == player

    override fun isTNTPoint(location: ConfiguredIntLocation): Boolean =
        gameModeProperty.tntSpawnPoint == location.vector

    override fun isTNTExplodePoint(location: ConfiguredIntLocation): Boolean =
        gameModeProperty.teamTNTLocations.containsValue(location.vector)

    override fun isTargetTNTPoint(location: ConfiguredIntLocation, player: ICarryTntPlayer): Boolean =
        isTNTExplodePoint(location) && (gameModeProperty.teamTNTLocations[player.team.property.id] != location.vector)

    abstract fun checkTntAcquisitionStatus(tntLocation: ConfiguredIntLocation, player: ICarryTntPlayer): Boolean

    protected fun getTnt(player: ICarryTntPlayer) {
        gameData.holdPlayer = player
        blockService.setBlock(tntBlockLocation!!.toLocation(world), "AIR")
        tntBlockLocation = null
        bossBars.values.forEach { it.color(player.team.property.id.uppercase()) }
    }

    protected fun getEnemyPoint(team: CarryTntTeam): ConfiguredIntVector {
        val enemy = teams.values.first { it != team } as CarryTntTeam
        return gameModeProperty.teamTNTLocations[enemy.property.id]!!
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

    override fun createScoreBoard() {
        scoreboard =
            scoreboardFactory.createScoreboardService().createScoreboard(config.display.scoreboard, placeholders)
    }

    override val placeholders: MutableMap<String, () -> String> = super.placeholders.apply {
//        put("%team1_tnt_distance%") { getFirstTeamTntTargetPointDistance().toString() }
//        put("%team2_tnt_distance%") { (100 - getFirstTeamTntTargetPointDistance()).toString() }
        put("%tnt_holder%") { gameData.holdPlayer?.getName() ?: "None" }
    }

    protected abstract fun getFirstTeamTntTargetPointDistance(): Double
}