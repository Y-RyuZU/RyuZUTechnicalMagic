package com.github.ryuzu.ryuzutechnicalmagiccore.core.util.wrapper.bossbar

import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.util.bossbar.ConfiguredBossBar
import com.github.ryuzu.ryuzutechnicalmagiccore.core.util.scheduler.ISimpleScheduler
import com.github.ryuzu.ryuzutechnicalmagiccore.core.util.scheduler.SimpleSchedulerFactory
import com.github.ryuzu.ryuzutechnicalmagiccore.core.util.scheduler.UpdatePeriod
import org.koin.core.component.inject
import java.util.UUID

abstract class AbstractBossBarService : IBossBarService {
    private val schedulerFactory: SimpleSchedulerFactory by inject()
    private lateinit var scheduler: ISimpleScheduler

    override fun createBossBar(bossBar: ConfiguredBossBar, placeholders: Map<String, () -> String>, period: UpdatePeriod): IBossBarService {
        scheduler = schedulerFactory.createScheduler(period).whileSchedule { _, count ->
            val frame = ((count / period.getPeriod()) % bossBar.titles.size).toInt()
            update(bossBar.titles[frame], placeholders)
        }.runSync()
        return this
    }

    override fun destroy() {
        scheduler.cancel()
    }

    abstract fun update(title: String, placeholders: Map<String, () -> String>)
}