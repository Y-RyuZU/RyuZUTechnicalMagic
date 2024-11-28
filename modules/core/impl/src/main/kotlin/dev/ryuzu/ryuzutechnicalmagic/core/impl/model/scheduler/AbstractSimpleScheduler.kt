package dev.ryuzu.ryuzutechnicalmagic.core.impl.model.scheduler

import dev.ryuzu.ryuzutechnicalmagic.api.core.model.scheduler.ISimpleScheduler
import dev.ryuzu.ryuzutechnicalmagic.api.core.model.scheduler.TaskUnit
import dev.ryuzu.ryuzutechnicalmagic.api.core.model.scheduler.UpdatePeriod

abstract class AbstractSimpleScheduler(val updatePeriod: UpdatePeriod) : ISimpleScheduler {
    private val tasks: MutableList<TaskUnit> = mutableListOf()
    private val additionalTasks: MutableList<TaskUnit> = mutableListOf()
    protected var endTask: () -> Unit = {}
    protected var finalTask: (Boolean) -> Unit = {}
    private var currentTick: Long = 0
    private var started = false
    private var abbreviated = false
    private var promiseTask: ISimpleScheduler? = null
    private var alwaysTimer = false

    override fun schedule(tasks: Set<TaskUnit>): ISimpleScheduler = apply {
        if (started){
            this.additionalTasks.addAll(tasks.map { it.copy(delay = currentTick + it.delay) })
            this.additionalTasks.sortWith(compareBy { it.delay + it.period })
        }
        else {
            this.tasks.addAll(tasks)
            this.tasks.sortWith(compareBy { it.delay + it.period })
        }
    }

    override fun end(task: () -> Unit): ISimpleScheduler = apply { endTask = task }
    override fun finally(task: (Boolean) -> Unit): ISimpleScheduler = apply { finalTask = task }

    override fun promise(task: ISimpleScheduler): ISimpleScheduler = apply {
        promiseTask = task
    }

    override fun cancel() {
        finalTask(false)
        stop()
    }

    override fun abbreviate() {
        abbreviated = true
        endTask()
        finalTask(true)
        promiseTask?.runSync(alwaysTimer)
        if(getEndTime() >= getAdditionalEndTime())
            stop()
    }

    override fun runSync(alwaysTimer: Boolean): ISimpleScheduler {
        started = true
        this.alwaysTimer = alwaysTimer
        return this
    }

    override fun runAsync(alwaysTimer: Boolean): ISimpleScheduler {
        started = true
        this.alwaysTimer = alwaysTimer
        return this
    }

    protected fun runnable() = Runnable {
        processTasks(tasks)
        processTasks(additionalTasks)

        if(abbreviated)
            tasks.clear()

        if (tasks.isEmpty() && !abbreviated) {
            endTask()
            finalTask(true)
            promiseTask?.runSync(alwaysTimer)
            if(getEndTime() >= getAdditionalEndTime())
                stop()
        }

        if(getEndTime() < getAdditionalEndTime() && additionalTasks.isEmpty())
            stop()

        currentTick++
    }

    protected fun getEndTime(): Long = tasks.maxOfOrNull { it.delay + it.period } ?: 0
    private fun getAdditionalEndTime(): Long = additionalTasks.maxOfOrNull { it.delay + it.period } ?: 0

    private fun processTasks(tasks: MutableList<TaskUnit>) {
        tasks.removeIf { task ->
            val isInTimeRange = currentTick in task.delay until task.delay + task.period
            if (isInTimeRange && task.condition(currentTick))
                task.task(this, currentTick)

            currentTick == task.delay + task.period - 1
        }
    }
}