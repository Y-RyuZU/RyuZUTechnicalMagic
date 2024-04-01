package com.github.ryuzu.ryuzutechnicalmagiccore.core.util.scheduler

import org.koin.core.annotation.InjectedParam
import java.util.SortedSet

abstract class AbstractSimpleScheduler(val updatePeriod: UpdatePeriod) : ISimpleScheduler {
    protected val tasks: MutableList<TaskUnit> = mutableListOf()
    protected var endTask: () -> Unit = {}
    protected var finalTask: (Boolean) -> Unit = {}
    private var currentTick: Long = 0

    override fun schedule(vararg tasks: TaskUnit): ISimpleScheduler = apply {
        this.tasks.addAll(tasks)
        this.tasks.sortWith(compareBy { it.delay + it.period })
    }

    override fun schedule(tasks: Set<TaskUnit>): ISimpleScheduler = apply {
        this.tasks.addAll(tasks)
        this.tasks.sortWith(compareBy { it.delay + it.period })
    }

    override fun end(task: () -> Unit): ISimpleScheduler = apply { endTask = task }
    override fun finally(task: (Boolean) -> Unit): ISimpleScheduler = apply { finalTask = task }

    override fun cancel() {
        finalTask(false)
        stop()
    }

    protected abstract fun stop()

    protected fun runnable() = Runnable {
        tasks.removeIf { task ->
            val isInTimeRange = currentTick in task.delay until task.delay + task.period
            if (isInTimeRange && task.condition(currentTick))
                task.task(this, currentTick)

            currentTick == task.delay + task.period - 1
        }

        if (currentTick + 1 >= getEndTime()) {
            endTask()
            finalTask(true)
            stop()
            return@Runnable
        }

        currentTick++
    }

    protected fun getEndTime(): Long = tasks.maxOfOrNull { it.delay + it.period } ?: 0
}