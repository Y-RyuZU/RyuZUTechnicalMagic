package dev.ryuzu.ryuzutechnicalmagic.core.impl.model.game.mode

import dev.ryuzu.ryuzutechnicalmagic.api.core.model.configuration.game.mode.ConfiguredGameMode
import dev.ryuzu.ryuzutechnicalmagic.api.core.model.configuration.game.mode.IConfiguredGameModeParameter
import dev.ryuzu.ryuzutechnicalmagic.api.core.model.configuration.game.stage.ConfiguredStage
import dev.ryuzu.ryuzutechnicalmagic.api.core.model.configuration.general.ConfiguredGeneralParameter
import dev.ryuzu.ryuzutechnicalmagic.api.core.model.entity.IPlayer
import dev.ryuzu.ryuzutechnicalmagic.api.core.model.game.entry.IEntryGameService
import dev.ryuzu.ryuzutechnicalmagic.api.core.model.game.level.ILevelService
import dev.ryuzu.ryuzutechnicalmagic.api.core.model.game.mode.IGameData
import dev.ryuzu.ryuzutechnicalmagic.api.core.model.game.mode.IGameService
import dev.ryuzu.ryuzutechnicalmagic.api.core.model.game.player.IGamePlayer
import dev.ryuzu.ryuzutechnicalmagic.api.core.model.game.stage.generator.IGeneratorService
import dev.ryuzu.ryuzutechnicalmagic.api.core.model.item.IItemManager
import dev.ryuzu.ryuzutechnicalmagic.api.core.model.placeholder.IPlaceholdable
import dev.ryuzu.ryuzutechnicalmagic.api.core.model.scheduler.ISchedulerFactory
import dev.ryuzu.ryuzutechnicalmagic.api.core.model.scheduler.ISimpleScheduler
import dev.ryuzu.ryuzutechnicalmagic.api.core.model.scheduler.UpdatePeriod
import dev.ryuzu.ryuzutechnicalmagic.api.core.util.StringUtility.Companion.tickToFormattedTime
import dev.ryuzu.ryuzutechnicalmagic.api.minecraft.adapter.block.IBlockAdapter
import dev.ryuzu.ryuzutechnicalmagic.api.core.model.effect.IEffectService
import dev.ryuzu.ryuzutechnicalmagic.api.minecraft.adapter.gamemode.IGameModeService
import dev.ryuzu.ryuzutechnicalmagic.api.minecraft.adapter.location.ILocationService
import dev.ryuzu.ryuzutechnicalmagic.api.minecraft.adapter.message.IMessageService
import dev.ryuzu.ryuzutechnicalmagic.api.core.model.effect.IParticleService
import dev.ryuzu.ryuzutechnicalmagic.api.minecraft.adapter.scoreboard.IScoreboardObject
import dev.ryuzu.ryuzutechnicalmagic.api.core.model.effect.ISoundService
import dev.ryuzu.ryuzutechnicalmagic.api.minecraft.adapter.structure.IStructureService
import dev.ryuzu.ryuzutechnicalmagic.api.minecraft.adapter.teleport.ITeleportService
import dev.ryuzu.ryuzutechnicalmagic.api.minecraft.adapter.title.ITitleService
import dev.ryuzu.ryuzutechnicalmagic.core.impl.util.wrapper.scoreboard.ScoreboardFactory
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import org.koin.core.parameter.parametersOf

abstract class AbstractGameService(
    override val world: String,
    protected val config: ConfiguredGameMode,
    protected val stage: ConfiguredStage,
    protected val entryService: IEntryGameService,
    entryPlayers: Set<IPlayer>,
) : IGameService, IPlaceholdable, KoinComponent {
    protected val generatorService: IGeneratorService by inject { parametersOf(this, stage.generators, stage) }
    protected val levelService: ILevelService by inject { parametersOf(this) }

    protected val schedulerFactory: ISchedulerFactory by inject()
    protected val messageService: IMessageService by inject()
    protected val titleService: ITitleService by inject()
    protected val particleService: IParticleService by inject()
    protected val effectService: IEffectService by inject()
    protected val soundService: ISoundService by inject()
    protected val blockService: IBlockAdapter by inject()
    protected val structureService: IStructureService by inject()
    protected val itemManager: IItemManager by inject()
    protected val teleportService: ITeleportService by inject()
    protected val gameModeService: IGameModeService by inject()
    protected val locationService: ILocationService by inject()
    protected val scoreboardFactory: ScoreboardFactory by inject()

    protected val parameter: ConfiguredGeneralParameter by inject()
    protected val players: MutableSet<IGamePlayer> = entryPlayers.map { createPlayer(it) }.toMutableSet()

    protected abstract val gameModeParameter: IConfiguredGameModeParameter
    protected abstract val gameModeProperty: dev.ryuzu.ryuzutechnicalmagic.api.core.configuration.game.stage.IConfiguredStageGameModeProperty
    protected abstract val gameData: IGameData
    protected abstract fun createPlayer(player: IPlayer): IGamePlayer

    protected val scheduler: ISimpleScheduler =
        schedulerFactory.createSimpleScheduler().whileSchedule { _, count -> gameData.time = count }
    protected val scoreboard: IScoreboardObject by lazy {
        scoreboardFactory.createScoreboardService().createScoreboard(config.display.scoreboard, placeholders)
    }

    init {
        players.addAll(entryService.entryPlayers.map { createPlayer(it) })
        messageService.sendMessage(listOf("Game Start !"), players)
        effectService.playEffect(config.effect, "GameStart", players)
        initialize()
    }

    private fun initialize() {
        createBossBar()
    }

    override fun joinGameMidway(player: IPlayer) {
        players.add(createPlayer(player))
        messageService.sendMessage(listOf("Game Start !"), player)
        effectService.playEffect(config.effect, "GameStart", player)
    }

    override fun end() {
        messageService.sendMessage(listOf("Game Over!"), players)
        effectService.playEffect(config.effect, "GameOver", players)
        teleportService.teleport(
            entryService.location.copy(vector = entryService.location.vector.copy(y = entryService.location.vector.y + 1)),
            players
        )
        generatorService.stop()
        scheduler.cancel()
        structureService.delete(world)
    }

    override fun leaveGame(player: IPlayer) {
        players.remove(getGamePlayer(player))
    }

    override fun getGamePlayer(player: IPlayer): IGamePlayer = players.first { it == player }
    override fun isGamePlayer(player: IPlayer): Boolean = players.any { it.id == player.id }

    override fun handlePlayerDeath(player: IGamePlayer, lastDamage: Double) {
        updateScores(player)
        lostStar(player, lastDamage)
        prepareForRespawn(player)
    }

    override fun getPhase(): Int = (gameData.time / (gameModeParameter.duration * 20 * 60)).toInt()

    override val placeholders: Map<String, () -> String> = mapOf(
        "%time%" to { gameData.time.tickToFormattedTime() },
        "%phase%" to { getPhase().toString() },
        "%stage%" to { stage.display.name }
    )

    private fun updateScores(gamePlayer: IGamePlayer) {
        gamePlayer.death++
    }

    private fun lostStar(gamePlayer: IGamePlayer, damage: Double) {
        generatorService.generateStar(
            locationService.getIntLocation(gamePlayer).toDoubleLocation(),
            (gamePlayer.star * stage.gameProperty.starLostRate).toInt(),
            parameter.generatorParameter.starLostScatter * damage
        )
        gamePlayer.star *= (1.0 - stage.gameProperty.starLostRate).toInt()
    }

    private fun prepareForRespawn(gamePlayer: IGamePlayer) {
        val respawnInterval = 5L
        schedulerFactory.createSimpleScheduler(UpdatePeriod.SECOND).schedule(0, respawnInterval) { _, count ->
            gameModeService.changeGameMode(3, gamePlayer, true)
            titleService.sendTitle(null, "Respawn in ${respawnInterval - count}", gamePlayer)
        }.schedule(respawnInterval) { _, _ ->
            gameModeService.changeGameMode(0, gamePlayer, false)
            titleService.sendTitle(null, "Respawn", gamePlayer)
            prepareForRespawn(gamePlayer)
        }.runSync()
    }

    protected abstract fun createBossBar()
    protected abstract fun respawnPlayer(player: IPlayer)
}