package com.github.ryuzu.ryuzutechnicalmagiccore.minecraft.implementation.util.wrapper.scheduler

import com.github.ryuzu.ryuzutechnicalmagiccore.RyuZUTechnicalMagicCore
import com.github.ryuzu.ryuzutechnicalmagiccore.core.util.scheduler.AbstractSimpleScheduler
import com.github.ryuzu.ryuzutechnicalmagiccore.core.util.scheduler.ISimpleScheduler
import org.bukkit.scheduler.BukkitRunnable
import org.koin.core.annotation.Factory
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

@Factory
class SimpleSchedulerImpl : AbstractSimpleScheduler(), KoinComponent {
    private val instance: RyuZUTechnicalMagicCore by inject()

    private val bukkitRunnable: BukkitRunnable = object : BukkitRunnable() {
        override fun run() = runnable().run()
    }

    override fun cancel() {
        super.cancel()
        bukkitRunnable.cancel()
    }

    override fun runSync(): ISimpleScheduler {
        runCommon {
            if(getEndTime() == 0L)
                bukkitRunnable.runTask(instance)
            else
                bukkitRunnable.runTaskTimer(instance, 0, 1)
        }
        return this
    }

    override fun runAsync(): ISimpleScheduler {
        runCommon {
            if(getEndTime() == 0L)
                bukkitRunnable.runTaskAsynchronously(instance)
            else
                bukkitRunnable.runTaskTimerAsynchronously(instance, 0, 1)
        }
        return this
    }

    private fun runCommon(runTask: () -> Unit) {
        val endTime = tasks.maxOfOrNull { it.delay + it.period } ?: 0
        if (endTime == 0L)
            runnable().run()
        else
            runTask.invoke()
    }
}