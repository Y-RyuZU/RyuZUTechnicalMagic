package com.github.ryuzu.ryuzutechnicalmagiccore.core.util.wrapper.scoreboard

import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.game.mode.ConfiguredScoreboard
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.player.IPlayer
import com.github.ryuzu.ryuzutechnicalmagiccore.core.util.scheduler.ISimpleScheduler
import com.github.ryuzu.ryuzutechnicalmagiccore.core.util.scheduler.SimpleSchedulerFactory
import com.github.ryuzu.ryuzutechnicalmagiccore.core.util.scheduler.UpdatePeriod
import org.koin.core.component.inject
import java.util.*

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