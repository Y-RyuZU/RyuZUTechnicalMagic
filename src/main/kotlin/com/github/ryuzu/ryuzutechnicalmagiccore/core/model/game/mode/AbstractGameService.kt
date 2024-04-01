package com.github.ryuzu.ryuzutechnicalmagiccore.core.model.game.mode

import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.game.general.ConfiguredGeneralParameter
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.game.mode.ConfiguredGameMode
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.game.mode.IConfiguredGameModeParameter
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.game.stage.ConfiguredStage
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.game.stage.IConfiguredStageGameModeProperty
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.game.entry.IEntryGameService
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.game.stage.generator.IGeneratorService
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.game.level.ILevelService
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.game.player.IGamePlayer
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.player.IPlayer
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.player.Player
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.skill.param.ISkillEventPrams.ICasterEventParams.CasterEventParams.IDamageEventParams
import com.github.ryuzu.ryuzutechnicalmagiccore.core.util.StringUtility.Companion.tickToFormattedTime
import com.github.ryuzu.ryuzutechnicalmagiccore.core.util.scheduler.ISimpleScheduler
import com.github.ryuzu.ryuzutechnicalmagiccore.core.util.wrapper.gamemode.IGameModeService
import com.github.ryuzu.ryuzutechnicalmagiccore.core.util.wrapper.location.ILocationService
import com.github.ryuzu.ryuzutechnicalmagiccore.core.util.wrapper.message.IMessageService
import com.github.ryuzu.ryuzutechnicalmagiccore.core.util.wrapper.particle.IParticleService
import com.github.ryuzu.ryuzutechnicalmagiccore.core.util.wrapper.sound.ISoundService
import com.github.ryuzu.ryuzutechnicalmagiccore.core.util.wrapper.teleport.ITeleportService
import com.github.ryuzu.ryuzutechnicalmagiccore.core.util.wrapper.title.ITitleService
import com.github.ryuzu.ryuzutechnicalmagiccore.core.util.scheduler.SimpleSchedulerFactory
import com.github.ryuzu.ryuzutechnicalmagiccore.core.util.wrapper.block.IBlockService
import com.github.ryuzu.ryuzutechnicalmagiccore.core.util.wrapper.structure.IStructureService
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import org.koin.core.parameter.parametersOf
import java.util.*

abstract class AbstractGameService(
    override val world: String,
    protected val config: ConfiguredGameMode,
    protected val stage: ConfiguredStage,
    protected val entryService: IEntryGameService,
    entryPlayers: Set<IPlayer>,
) : IGameService, KoinComponent {
    protected val generatorService: IGeneratorService by inject { parametersOf(this) }
    protected val levelService: ILevelService by inject { parametersOf(this) }
    protected val schedulerFactory: SimpleSchedulerFactory by inject()
    protected val messageService: IMessageService by inject()
    protected val titleService: ITitleService by inject()
    protected val soundService: ISoundService by inject()
    protected val particleService: IParticleService by inject()
    protected val teleportService: ITeleportService by inject()
    protected val gameModeService: IGameModeService by inject()
    protected val locationService: ILocationService by inject()
    protected val blockService: IBlockService by inject()
    protected val structureService: IStructureService by inject()

    protected val parameter: ConfiguredGeneralParameter by inject()
    protected val players: MutableSet<IGamePlayer> = entryPlayers.map { createPlayer(it) }.toMutableSet()

    protected abstract val gameModeParameter: IConfiguredGameModeParameter
    protected abstract val gameModeProperty: IConfiguredStageGameModeProperty
    protected abstract val gameData: IGameData
    protected abstract fun createPlayer(player: IPlayer): IGamePlayer

    protected lateinit var scheduler: ISimpleScheduler

    override fun start() {
        players.addAll(entryService.entryPlayers.map { createPlayer(it) })
        messageService.sendMessage(listOf("Game Start !"), players)
        config.effects.sounds["GameStart"]?.let { soundService.playSound(it, players) }
        config.effects.particles["GameStart"]?.let { particleService.spawnParticle(it, players) }
        createBossBar()
        createScoreBoard()
        scheduler = schedulerFactory.createScheduler().whileSchedule { _, count -> gameData.time = count }
    }

    override fun joinGameMidway(player: IPlayer) {
        players.add(createPlayer(player))
        messageService.sendMessage(listOf("Game Start !"), player)
        config.effects.sounds["GameStart"]?.let { soundService.playSound(it, player) }
        config.effects.particles["GameStart"]?.let { particleService.spawnParticle(it, player) }
    }

    override fun end() {
        messageService.sendMessage(listOf("Game Over!"), players)
        config.effects.sounds["GameOver"]?.let { soundService.playSound(it, players) }
        config.effects.particles["GameOver"]?.let { particleService.spawnParticle(it, players) }
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

    protected open val placeholders: MutableMap<String, () -> String> = mutableMapOf<String, () -> String>().apply {
        put("%time%") { gameData.time.tickToFormattedTime() }
        put("%phase%") { getPhase().toString() }
        put("%stage%") { stage.display.name }
    }

    override fun getPhase(): Int = (gameData.time / (gameModeParameter.duration * 20 * 60)).toInt()

    protected abstract fun createBossBar()
    protected abstract fun createScoreBoard()
    protected abstract fun respawnPlayer(player: IPlayer)
}