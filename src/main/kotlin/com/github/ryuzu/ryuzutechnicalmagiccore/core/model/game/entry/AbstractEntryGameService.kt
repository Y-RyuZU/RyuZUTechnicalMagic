package com.github.ryuzu.ryuzutechnicalmagiccore.core.model.game.entry

import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.base.ConfiguredIntLocation
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.game.entry.ConfiguredEntry
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.game.mode.ConfiguredGameMode
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.game.stage.ConfiguredStage
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.game.mode.GameMode
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.game.mode.IGameService
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.player.IPlayer
import com.github.ryuzu.ryuzutechnicalmagiccore.core.util.CollectionUtility.Companion.getRandomKey
import com.github.ryuzu.ryuzutechnicalmagiccore.core.util.wrapper.message.IMessageService
import com.github.ryuzu.ryuzutechnicalmagiccore.core.util.wrapper.particle.IParticleService
import com.github.ryuzu.ryuzutechnicalmagiccore.core.util.wrapper.sound.ISoundService
import com.github.ryuzu.ryuzutechnicalmagiccore.core.util.wrapper.structure.IStructureService
import com.github.ryuzu.ryuzutechnicalmagiccore.core.util.scheduler.SimpleSchedulerFactory
import com.github.ryuzu.ryuzutechnicalmagiccore.core.util.scheduler.UpdatePeriod
import org.koin.core.component.inject
import org.koin.core.qualifier.named
import java.time.LocalTime
import java.time.format.DateTimeFormatter

abstract class AbstractEntryGameService(
    override val location: ConfiguredIntLocation,
) : IEntryGameService {
//    private val defaultGameMode: GameMode by inject()
    private val config: ConfiguredEntry by inject()

    private val schedulerFactory: SimpleSchedulerFactory by inject()
    private val messageService: IMessageService by inject()
    private val soundService: ISoundService by inject()
    private val particleService: IParticleService by inject()
    private val structureService: IStructureService by inject()

    private val stages: Map<String, ConfiguredStage> by inject(named("StageConfig"))
    private val gameModeConfigs: Map<GameMode, ConfiguredGameMode> by inject(named("GameModeConfig"))
    override val entryPlayers: MutableSet<IPlayer> = mutableSetOf()
//    override var gameMode: GameMode = GameMode.entries.toTypedArray()[Random.nextInt(GameMode.entries.size)]
    override var gameMode: GameMode = GameMode.CarryTnt
    override var stageId: String? = null
    override var isStart: Boolean = false

    private lateinit var gameService: IGameService
    private var preparing = false

    override fun entry(player: IPlayer) {
        println("Enter")

        entryPlayers.add(player)
        config.effects.sounds["Entry"]?.let { player.playSound(it) }

        if (isStart)
            enterMidway(player)
        else if (!preparing && getMinimumPlayer() <= entryPlayers.size)
            prepare()
    }

    override fun leave(player: IPlayer) {
        println("Leave")

        entryPlayers.remove(player)
    }

    private fun enterMidway(player: IPlayer) {
        println("EnterMidway")

        entryPlayers.add(player)
        gameService.joinGameMidway(player)
    }

    private fun prepare() {
        println("Prepare")

        val selectedStage: String = stageId ?: stages.getRandomKey()!!
        val stage: ConfiguredStage = stages[selectedStage] ?: throw IllegalArgumentException("$selectedStage's config is not found")
        val world = getWorldId(selectedStage)
        val structureScheduler = structureService.read(world, stage.structure)
        schedulerFactory.createScheduler(UpdatePeriod.HALF_SECOND).schedule(0, 10) { schedule, count ->
            if (entryPlayers.size < getMinimumPlayer()) {
                structureScheduler.cancel()
                schedule.cancel()
                return@schedule
            }
            countDownEffect(10L - count)
        }.finally{
            preparing = false
        }.end {
            gameService = gameMode.getService(world, getConfig(), stage, this, entryPlayers.toSet())
            gameService.start()
            isStart = true
        }.runSync()
        preparing = true
    }

    private fun countDownEffect(count: Long) {
        messageService.sendMessage(listOf("Game will start in $count seconds"), entryPlayers)
        config.effects.sounds["CountDown"]?.let { soundService.playSound(it, entryPlayers) }
        config.effects.particles["CountDown"]?.let { particleService.spawnParticle(it, entryPlayers) }
    }

    private fun getWorldId(selectedStageId: String): String =
        "${ location.world }_${location.vector.x}_${location.vector.y}_${location.vector.z}_${selectedStageId}_${currentTimeWithoutDelimiter()}"
    private fun currentTimeWithoutDelimiter(): String {
        val formatter = DateTimeFormatter.ofPattern("HHmmss")
        return LocalTime.now().format(formatter)
    }

    private fun getConfig(): ConfiguredGameMode = gameModeConfigs[gameMode] ?: throw IllegalArgumentException("$gameMode's config is not found")

    override fun getMinimumPlayer(): Int = getConfig().parameter.minimumPlayerCount
    override fun getMaximumPlayer(): Int = getConfig().parameter.maximumPlayerCount
    override fun isEntryPlayer(player: IPlayer): Boolean = entryPlayers.contains(player)
    override fun getEntryPlayerNumber(): Int = entryPlayers.size
}