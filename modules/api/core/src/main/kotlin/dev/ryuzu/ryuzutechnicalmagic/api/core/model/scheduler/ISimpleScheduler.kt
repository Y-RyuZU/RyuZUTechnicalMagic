package dev.ryuzu.ryuzutechnicalmagic.api.core.model.scheduler

interface ISimpleScheduler {
    fun schedule(tasks: Set<TaskUnit>): ISimpleScheduler
    fun schedule(vararg tasks: TaskUnit): ISimpleScheduler = schedule(tasks.toSet())
    fun promise(task: ISimpleScheduler): ISimpleScheduler

    fun schedule(
        delay: Long = 0,
        period: Long = 1,
        condition: (Long) -> Boolean = { true },
        task: (ISimpleScheduler, Long) -> Unit
    ): ISimpleScheduler =
        schedule(TaskUnit(delay, period, condition, task))

    fun whileSchedule(
        condition: (Long) -> Boolean = { true },
        task: (ISimpleScheduler, Long) -> Unit
    ): ISimpleScheduler =
        schedule(0, Long.MAX_VALUE, condition, task)

    fun end(task: () -> Unit): ISimpleScheduler
    fun finally(task: (Boolean) -> Unit): ISimpleScheduler

    fun runSync(alwaysTimer: Boolean = false): ISimpleScheduler
    fun runAsync(alwaysTimer: Boolean = false): ISimpleScheduler
    fun cancel()
    fun abbreviate()
    fun stop()
}