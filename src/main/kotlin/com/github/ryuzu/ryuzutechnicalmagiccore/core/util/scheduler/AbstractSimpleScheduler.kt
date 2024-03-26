package com.github.ryuzu.ryuzutechnicalmagiccore.core.util.scheduler

import java.util.SortedSet

abstract class AbstractSimpleScheduler : ISimpleScheduler {
    val tasks: SortedSet<TaskUnit> = sortedSetOf(compareBy { it.delay + it.period })
    var endTask: () -> Unit = {}
    var finalTask: (Boolean) -> Unit = {}
    private var currentTick: Long = 0
    private var canceled: Boolean = false

    override fun schedule(vararg tasks: TaskUnit): ISimpleScheduler = apply { this.tasks.addAll(tasks) }
    override fun schedule(tasks: Set<TaskUnit>): ISimpleScheduler = apply { this.tasks.addAll(tasks) }

    override fun end(task: () -> Unit): ISimpleScheduler = apply { endTask = task }
    override fun finally(task: (Boolean) -> Unit): ISimpleScheduler = apply { finalTask = task }

    override fun cancel() {
        canceled = true
        finalTask(false)
    }

    protected fun runnable() = Runnable {
        if (canceled)
            return@Runnable

        tasks.removeIf { task ->
            val isInTimeRange = currentTick in task.delay until task.delay + task.period
            if (isInTimeRange && task.condition(currentTick))
                task.task(this, currentTick)

            currentTick == task.delay + task.period
        }

        if (currentTick > getEndTime()) {
            endTask()
            finalTask(true)
            return@Runnable
        }

        currentTick++
    }

    protected fun getEndTime(): Long = tasks.maxOfOrNull { it.delay + it.period } ?: 0
}