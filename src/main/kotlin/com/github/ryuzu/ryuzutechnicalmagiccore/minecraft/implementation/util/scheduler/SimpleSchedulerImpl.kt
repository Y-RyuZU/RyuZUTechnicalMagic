package com.github.ryuzu.ryuzutechnicalmagiccore.minecraft.implementation.util.scheduler

import com.github.ryuzu.ryuzutechnicalmagiccore.RyuZUTechnicalMagicCore
import com.github.ryuzu.ryuzutechnicalmagiccore.core.util.scheduler.AbstractSimpleScheduler
import com.github.ryuzu.ryuzutechnicalmagiccore.core.util.scheduler.ISimpleScheduler
import com.github.ryuzu.ryuzutechnicalmagiccore.core.util.scheduler.UpdatePeriod
import org.bukkit.Bukkit
import org.bukkit.scheduler.BukkitRunnable
import org.bukkit.scheduler.BukkitTask
import org.koin.core.annotation.Factory
import org.koin.core.annotation.InjectedParam
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

@Factory([ISimpleScheduler::class])
class SimpleSchedulerImpl(@InjectedParam updatePeriod: UpdatePeriod) : AbstractSimpleScheduler(updatePeriod), KoinComponent {
    private val instance: RyuZUTechnicalMagicCore by inject()

    private val bukkitScheduler = Bukkit.getScheduler()
    private lateinit var bukkitTask: BukkitTask

    override fun stop() {
        bukkitTask.cancel()
    }

    override fun runSync(alwaysTimer: Boolean): ISimpleScheduler {
        super.runSync(alwaysTimer)
        bukkitTask = if(!alwaysTimer && getEndTime() == 1L)
            bukkitScheduler.runTask(instance, runnable())
        else
            bukkitScheduler.runTaskTimer(instance, runnable(), 0, updatePeriod.getPeriod())
        return this
    }

    override fun runAsync(alwaysTimer: Boolean): ISimpleScheduler {
        super.runAsync(alwaysTimer)
        bukkitTask = if(!alwaysTimer && getEndTime() == 1L)
            bukkitScheduler.runTaskAsynchronously(instance, runnable())
        else
            bukkitScheduler.runTaskTimerAsynchronously(instance, runnable(), 0, updatePeriod.getPeriod())
        return this
    }
}