package dev.ryuzu.ryuzutechnicalmagic.core.impl.util.wrapper.scoreboard

import dev.ryuzu.ryuzutechnicalmagic.api.core.model.configuration.game.mode.ConfiguredScoreboard
import dev.ryuzu.ryuzutechnicalmagic.api.core.model.scheduler.ISimpleScheduler
import dev.ryuzu.ryuzutechnicalmagic.api.core.model.scheduler.UpdatePeriod
import dev.ryuzu.ryuzutechnicalmagic.api.minecraft.adapter.scoreboard.IScoreboardService
import dev.ryuzu.ryuzutechnicalmagic.core.impl.model.scheduler.SimpleSchedulerFactory
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

abstract class AbstractScoreboardService : IScoreboardService, KoinComponent {
    private val schedulerFactory: SimpleSchedulerFactory by inject()
    private lateinit var scheduler: ISimpleScheduler

    override fun createScoreboard(scoreboard: List<ConfiguredScoreboard>, placeholders: Map<String, () -> String>, period: UpdatePeriod): IScoreboardService {
        scheduler = schedulerFactory.createSimpleScheduler(period).whileSchedule{ _, count ->
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