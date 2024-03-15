package com.github.ryuzu.ryuzutechnicalmagiccore.core.util.scheduler

import java.util.*

interface ISimpleScheduler {
    val tasks: SortedSet<TaskUnit>
    var endTask: () -> Unit
    var currentTick: Long

    fun schedule(task: TaskUnit): ISimpleScheduler = apply { tasks.add(task) }

    fun schedule(
        delay: Long = 0,
        period: Long = 0,
        condition: (Long) -> Boolean = { true },
        task: (ISimpleScheduler, Long) -> Unit
    ): ISimpleScheduler =
        schedule(TaskUnit(delay, period, condition, task))

    fun end(task: () -> Unit): ISimpleScheduler = apply { endTask = task }

    fun runSync()
    fun runAsync()
    fun cancel() = tasks.clear()

    fun runnable() = Runnable {
        val endTime = tasks.maxOfOrNull { it.delay + it.period } ?: 0

        if (tasks.isEmpty()) {
            this.cancel()
            return@Runnable
        }

        tasks.removeIf { task ->
            val isInTimeRange = currentTick in task.delay until task.delay + task.period
            if (isInTimeRange && task.condition(currentTick))
                task.task(this, currentTick)

            currentTick == task.delay + task.period
        }

        if (currentTick > endTime) {
            endTask()
            this.cancel()
            return@Runnable
        }

        currentTick++
    }
}