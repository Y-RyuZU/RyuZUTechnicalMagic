package com.github.ryuzu.ryuzutechnicalmagiccore.minecraft.implementation.scheduler

import com.github.ryuzu.ryuzutechnicalmagiccore.RyuZUTechnicalMagicCore
import com.github.ryuzu.ryuzutechnicalmagiccore.core.util.scheduler.AbstractSimpleScheduler
import org.bukkit.scheduler.BukkitRunnable
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class SimpleScheduler : AbstractSimpleScheduler(), KoinComponent {
    private val instance: RyuZUTechnicalMagicCore by inject()

    private val bukkitRunnable: BukkitRunnable = object : BukkitRunnable() {
        override fun run() = runnable().run()
    }

    override fun cancel() {
        super.cancel()
        bukkitRunnable.cancel()
    }

    override fun runSync() = runCommon { bukkitRunnable.runTaskTimer(instance, 0, 1) }
    override fun runAsync() = runCommon { bukkitRunnable.runTaskTimerAsynchronously(instance, 0, 1) }

    private fun runCommon(runTask: () -> Unit) {
        val endTime = tasks.maxOfOrNull { it.delay + it.period } ?: 0
        if (endTime == 0L)
            runnable().run()
        else
            runTask.invoke()
    }
}