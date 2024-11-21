package dev.ryuzu.ryuzutechnicalmagiccore.util.wrapper.bossbar

import dev.ryuzu.ryuzutechnicalmagiccore.model.configuration.util.bossbar.ConfiguredBossBar
import dev.ryuzu.ryuzutechnicalmagiccore.model.scheduler.ISimpleScheduler
import dev.ryuzu.ryuzutechnicalmagiccore.model.scheduler.SimpleSchedulerFactory
import dev.ryuzu.ryuzutechnicalmagiccore.model.scheduler.UpdatePeriod
import org.koin.core.component.inject

abstract class AbstractBossBarService : dev.ryuzu.ryuzutechnicalmagiccore.core.util.wrapper.bossbar.IBossBarService {
    private val schedulerFactory: SimpleSchedulerFactory by inject()
    private lateinit var scheduler: ISimpleScheduler

    override fun createBossBar(config: ConfiguredBossBar, placeholders: Map<String, () -> String>, period: UpdatePeriod): dev.ryuzu.ryuzutechnicalmagiccore.core.util.wrapper.bossbar.IBossBarService {
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