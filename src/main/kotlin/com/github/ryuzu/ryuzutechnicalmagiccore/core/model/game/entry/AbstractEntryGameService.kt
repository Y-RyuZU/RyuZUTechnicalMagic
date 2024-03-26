package com.github.ryuzu.ryuzutechnicalmagiccore.core.model.game.entry

import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.base.ConfiguredIntLocation
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.game.entry.ConfiguredEntry
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.game.stage.ConfiguredStage
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.game.mode.GameMode
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.game.mode.IGameService
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.player.IPlayer
import com.github.ryuzu.ryuzutechnicalmagiccore.core.util.CollectionUtility.Companion.getRandomKey
import com.github.ryuzu.ryuzutechnicalmagiccore.core.util.wrapper.message.IMessageService
import com.github.ryuzu.ryuzutechnicalmagiccore.core.util.wrapper.particle.IParticleService
import com.github.ryuzu.ryuzutechnicalmagiccore.core.util.wrapper.sound.ISoundService
import com.github.ryuzu.ryuzutechnicalmagiccore.core.util.wrapper.structure.IStructureService
import com.github.ryuzu.ryuzutechnicalmagiccore.core.util.wrapper.teleport.ITeleportService
import com.github.ryuzu.ryuzutechnicalmagiccore.core.util.scheduler.SimpleSchedulerFactory
import org.koin.core.component.inject
import org.koin.core.qualifier.named
import java.util.*
import org.koin.core.component.get
import org.koin.core.parameter.parametersOf
import java.time.LocalTime
import java.time.format.DateTimeFormatter

abstract class AbstractEntryGameService(
    override val location: ConfiguredIntLocation,
) : IEntryGameService {
    private val defaultGameMode: GameMode by inject()
    private val config: ConfiguredEntry by inject()

    private val schedulerFactory: SimpleSchedulerFactory by inject()
    private val messageService: IMessageService by inject()
    private val soundService: ISoundService by inject()
    private val particleService: IParticleService by inject()
    private val teleportService: ITeleportService by inject()
    private val structureService: IStructureService by inject()

    private val stages: Map<String, ConfiguredStage> by inject()
    override val entryPlayers: MutableSet<IPlayer> = mutableSetOf()
    override var gameMode: GameMode = defaultGameMode
    override var stageId: String? = null
    override var isStart: Boolean = false

    private lateinit var gameService: IGameService
    private var preparing = false

    override fun entry(player: IPlayer) {
        println("Enter")

        entryPlayers.add(player)

        if (isStart)
            enterMidway(player)
        else if (!preparing)
            prepare()
    }

    override fun leave(player: IPlayer) {
        println("Leave")

        entryPlayers.remove(player)
        gameService.leaveGame(player)
        teleportService.teleport(location, player)
    }

    private fun enterMidway(player: IPlayer) {
        println("EnterMidway")

        entryPlayers.add(player)
        gameService.joinGameMidway(player)
    }

    private fun prepare() {
        println("Prepare")

        val selectedStage = stageId ?: stages.getRandomKey()!!
        val stage: ConfiguredStage = get<ConfiguredStage> { parametersOf(selectedStage) }
        val world = getWorldId(selectedStage)
        val structureScheduler = structureService.read(world, stage.id)
        schedulerFactory.createScheduler().schedule(0, 10) { schedule, count ->
            if (entryPlayers.size < getMinimumPlayer()) {
                structureScheduler.cancel()
                schedule.cancel()
                return@schedule
            }
            countDownEffect(10L - count)
        }.end {
            gameService = gameMode.start(stage, world)
            gameService.start()
            isStart = true
        }
        preparing = true
    }

    private fun countDownEffect(count: Long) {
        messageService.sendMessage(listOf("Game will start in $count seconds"), entryPlayers)
        config.effects.sounds["CountDown"]?.let { soundService.playSound(it, entryPlayers) }
        config.effects.particles["CountDown"]?.let { particleService.spawnParticle(it, entryPlayers) }
    }

    fun getWorldId(selectedStageId: String): String = location.world + "_" + location.vector.x + "_" + location.vector.y + "_" + location.vector.z + "_" + selectedStageId + "_" + currentTimeWithoutDelimiter()
    private fun currentTimeWithoutDelimiter(): String {
        val formatter = DateTimeFormatter.ofPattern("HHmmss")
        return LocalTime.now().format(formatter)
    }

    override fun getMinimumPlayer(): Int = get<Int>(named("minimumPlayerNumber")) { parametersOf(gameMode) }
    override fun getMaximumPlayer(): Int = get<Int>(named("maximumPlayerNumber")) { parametersOf(gameMode) }
    override fun isEntryPlayer(player: IPlayer): Boolean = entryPlayers.contains(player)
    override fun getEntryPlayerNumber(): Int = entryPlayers.size
}