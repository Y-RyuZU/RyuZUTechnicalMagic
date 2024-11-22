package dev.ryuzu.ryuzutechnicalmagiccore.model.game.entry

import dev.ryuzu.ryuzutechnicalmagiccore.model.configuration.base.ConfiguredIntLocation
import dev.ryuzu.ryuzutechnicalmagiccore.model.configuration.game.entry.ConfiguredEntry
import dev.ryuzu.ryuzutechnicalmagiccore.model.configuration.game.mode.ConfiguredGameMode
import dev.ryuzu.ryuzutechnicalmagiccore.model.configuration.game.stage.ConfiguredStage
import dev.ryuzu.ryuzutechnicalmagiccore.model.game.mode.GameMode
import dev.ryuzu.ryuzutechnicalmagiccore.model.game.mode.IGameService
import dev.ryuzu.ryuzutechnicalmagiccore.model.entity.IPlayer
import dev.ryuzu.ryuzutechnicalmagiccore.util.CollectionUtility.Companion.getRandomKey
import dev.ryuzu.ryuzutechnicalmagiccore.model.scheduler.SimpleSchedulerFactory
import dev.ryuzu.ryuzutechnicalmagiccore.model.scheduler.UpdatePeriod
import dev.ryuzu.ryuzutechnicalmagiccore.util.wrapper.effect.IEffectService
import dev.ryuzu.ryuzutechnicalmagiccore.util.wrapper.message.IMessageService
import dev.ryuzu.ryuzutechnicalmagiccore.util.wrapper.structure.IStructureService
import org.koin.core.annotation.Factory
import org.koin.core.annotation.InjectedParam
import org.koin.core.component.inject
import org.koin.core.qualifier.named
import java.time.LocalTime
import java.time.format.DateTimeFormatter

@Factory([IEntryGameService::class])
class EntryGameServiceImpl(
    @InjectedParam override val location: ConfiguredIntLocation,
) : IEntryGameService {
//    private val defaultGameMode: GameMode by inject()
    private val config: ConfiguredEntry by inject()

    private val schedulerFactory: SimpleSchedulerFactory by inject()
    private val messageService: IMessageService by inject()
    private val effectService: IEffectService by inject()
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
        effectService.playEffect(config.effect, "Entry", player)

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
            isStart = true
        }.runSync()
        preparing = true
    }

    private fun countDownEffect(count: Long) {
        messageService.sendMessage(listOf("Game will start in $count seconds"), entryPlayers)
        effectService.playEffect(config.effect, "CountDown", entryPlayers)
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