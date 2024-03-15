package com.github.ryuzu.ryuzutechnicalmagiccore.minecraft.implementation.scheduler

import com.github.ryuzu.ryuzutechnicalmagiccore.RyuZUTechnicalMagicCore
import com.github.ryuzu.ryuzutechnicalmagiccore.core.util.scheduler.AbstractSimpleScheduler
import org.bukkit.Bukkit
import org.bukkit.scheduler.BukkitRunnable

class SimpleScheduler : AbstractSimpleScheduler() {
    private val core = RyuZUTechnicalMagicCore.instance

    private val bukkitRunnable: BukkitRunnable = object : BukkitRunnable() {
        override fun run() = runnable().run()
    }

    override fun cancel() {
        super.cancel()
        bukkitRunnable.cancel()
    }

    override fun runSync() = runCommon { bukkitRunnable.runTaskTimer(core, 0, 1) }
    override fun runAsync() = runCommon { bukkitRunnable.runTaskTimerAsynchronously(core, 0, 1) }

    private fun runCommon(runTask: () -> Unit) {
        val endTime = tasks.maxOfOrNull { it.delay + it.period } ?: 0
        if (endTime == 0L)
            runnable().run()
        else
            runTask.invoke()
    }
}