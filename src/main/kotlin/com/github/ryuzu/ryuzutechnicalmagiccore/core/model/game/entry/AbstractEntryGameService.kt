package com.github.ryuzu.ryuzutechnicalmagiccore.core.model.game.entry

import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.game.mode.GameMode
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.game.mode.IGameService
import com.github.ryuzu.ryuzutechnicalmagiccore.minecraft.implementation.util.scheduler.SimpleSchedulerFactory
import org.koin.core.component.inject
import org.koin.core.qualifier.named
import java.util.*
import org.koin.core.component.get
import org.koin.core.parameter.parametersOf

abstract class AbstractEntryGameService : IEntryGameService {
    private val minimumPlayer: Int by inject(named("minimumPlayer"))
    private val defaultGameMode: GameMode by inject()
    private val schedulerFactory: SimpleSchedulerFactory by inject()
    private val entryPlayers: MutableSet<UUID> = mutableSetOf()
    override var gameMode: GameMode = defaultGameMode
    override var isStart: Boolean = false

    private lateinit var gameService: IGameService
    private var preparing = false

    override fun entry(player: UUID) {
        println("Enter")

        entryPlayers.add(player)

        if (isStart)
            enterMidway(player)
        else if (!preparing)
            prepare()
    }

    override fun leave(player: UUID) {
        println("Leave")

        entryPlayers.remove(player)
    }

    private fun enterMidway(player: UUID) {
        println("EnterMidway")

        entryPlayers.add(player)
    }

    private fun start() {
        println("Start")

        gameService = gameMode.start(entryPlayers)
        isStart = true
    }

    private fun prepare() {
        println("Prepare")

        countDown()
        preparing = true
    }

    private fun countDown() {
        println("CountDown")

        schedulerFactory.createScheduler().schedule(0, 10) { schedule, count ->
            if (entryPlayers.size < minimumPlayer) {
                schedule.cancel()
                return@schedule
            }
            countDownEffect(10L - count)
        }.end { start() }
    }

    protected abstract fun countDownEffect(count: Long)

    override fun getMinimumPlayer(): Int = get<Int>(named("minimumPlayerNumber")) { parametersOf(gameMode) }
    override fun getMaximumPlayer(): Int = get<Int>(named("maximumPlayerNumber")) { parametersOf(gameMode) }
    override fun isEntryPlayer(player: UUID): Boolean = entryPlayers.contains(player)
    override fun getEntryPlayerNumber(): Int = entryPlayers.size

}