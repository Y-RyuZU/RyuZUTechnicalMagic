package dev.ryuzu.ryuzutechnicalmagic.core.impl.model.scheduler

import dev.ryuzu.ryuzutechnicalmagic.api.core.model.scheduler.ISimpleScheduler
import dev.ryuzu.ryuzutechnicalmagic.api.core.model.scheduler.TaskUnit
import dev.ryuzu.ryuzutechnicalmagic.api.core.model.scheduler.UpdatePeriod
import java.util.concurrent.PriorityBlockingQueue

abstract class AbstractSimpleScheduler(val updatePeriod: UpdatePeriod) : ISimpleScheduler {
    private val tasks = PriorityBlockingQueue<TaskUnit>(10, compareBy { it.delay })
    private val additionalTasks = PriorityBlockingQueue<TaskUnit>(10, compareBy { it.delay })
    protected var endTask: () -> Unit = {}
    protected var finalTask: (Boolean) -> Unit = {}
    private var currentTick: Long = 0
    private var started = false
    private var abbreviated = false
    private var promiseTask: ISimpleScheduler? = null
    private var alwaysTimer = false

    override fun schedule(tasks: Set<TaskUnit>): ISimpleScheduler = apply {
        val absoluteTasks = tasks.map { it.copy(delay = currentTick + it.delay) }
        this.tasks.addAll(absoluteTasks)
        this.additionalTasks.addAll(absoluteTasks)
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

    override fun skip() {
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

        additionalTasks.clear()
        currentTick++
    }

    protected fun getEndTime(): Long = tasks.maxOfOrNull { it.delay + it.period } ?: 0
    private fun getAdditionalEndTime(): Long = additionalTasks.maxOfOrNull { it.delay + it.period } ?: 0

    private fun processTasks(tasks: PriorityBlockingQueue<TaskUnit>) {
        val stayTasks = mutableListOf<TaskUnit>()
        while (tasks.isNotEmpty()) {
            if(currentTick < tasks.peek().delay)
                break

            val task = tasks.poll()
            task.task(this, currentTick)

            if (currentTick < task.getAbsolutePeriod() - 1)
                stayTasks.add(task)
        }
        tasks.addAll(stayTasks)
    }
}