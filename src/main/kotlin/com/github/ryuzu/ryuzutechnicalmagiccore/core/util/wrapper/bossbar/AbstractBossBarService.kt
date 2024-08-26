package com.github.ryuzu.ryuzutechnicalmagiccore.core.util.wrapper.bossbar

import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.util.bossbar.ConfiguredBossBar
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.scheduler.ISimpleScheduler
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.scheduler.SimpleSchedulerFactory
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.scheduler.UpdatePeriod
import org.koin.core.component.inject

abstract class AbstractBossBarService : IBossBarService {
    private val schedulerFactory: SimpleSchedulerFactory by inject()
    private lateinit var scheduler: ISimpleScheduler

    override fun createBossBar(config: ConfiguredBossBar, placeholders: Map<String, () -> String>, period: UpdatePeriod): IBossBarService {
        scheduler = schedulerFactory.createScheduler(period).whileSchedule { _, count ->
            val frame = ((count / period.getPeriod()) % config.titles.size).toInt()
            update(config.titles[frame], placeholders)
        }.runSync()
        return this
    }

    override fun destroy() {
        scheduler.cancel()
    }

    abstract fun update(title: String, placeholders: Map<String, () -> String>)
}