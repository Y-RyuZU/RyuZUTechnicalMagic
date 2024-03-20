package com.github.ryuzu.ryuzutechnicalmagiccore.core.util.scheduler

import java.util.SortedSet

abstract class AbstractSimpleScheduler : ISimpleScheduler {
    val tasks: SortedSet<TaskUnit> = sortedSetOf(compareBy { it.delay + it.period })
    var endTask: () -> Unit = {}
    private var currentTick: Long = 0

    override fun schedule(vararg tasks: TaskUnit): ISimpleScheduler = apply { this.tasks.addAll(tasks) }
    override fun schedule(tasks: Set<TaskUnit>): ISimpleScheduler = apply { this.tasks.addAll(tasks) }

    override fun end(task: () -> Unit): ISimpleScheduler = apply { endTask = task }

    override fun cancel() = tasks.clear()

    protected fun runnable() = Runnable {
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