package dev.ryuzu.ryuzutechnicalmagiccore.util.wrapper.scoreboard

import dev.ryuzu.ryuzutechnicalmagiccore.model.configuration.game.mode.ConfiguredScoreboard
import dev.ryuzu.ryuzutechnicalmagiccore.model.scheduler.ISimpleScheduler
import dev.ryuzu.ryuzutechnicalmagiccore.model.scheduler.SimpleSchedulerFactory
import dev.ryuzu.ryuzutechnicalmagiccore.model.scheduler.UpdatePeriod
import org.koin.core.component.inject

abstract class AbstractScoreboardService : IScoreboardService {
    private val schedulerFactory: SimpleSchedulerFactory by inject()
    private lateinit var scheduler: ISimpleScheduler

    override fun createScoreboard(scoreboard: List<ConfiguredScoreboard>, placeholders: Map<String, () -> String>, period: UpdatePeriod): IScoreboardService {
        scheduler = schedulerFactory.createScheduler(period).whileSchedule{ _, count ->
            val frame = ((count / period.getPeriod()) % scoreboard.size).toInt()
            update(scoreboard[frame].title, scoreboard[frame].lines, placeholders)
        }.runSync()
        return this
    }

    override fun destroy() {
        scheduler.cancel()
    }

    abstract fun update(title: String, lines: List<String>, placeholders: Map<String, () -> String>)
}