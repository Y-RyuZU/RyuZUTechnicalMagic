package com.github.ryuzu.ryuzutechnicalmagiccore.core.util.scheduler

interface ISimpleScheduler {
    fun schedule(vararg tasks: TaskUnit): ISimpleScheduler
    fun schedule(tasks: Set<TaskUnit>): ISimpleScheduler

    fun schedule(
        delay: Long = 0,
        period: Long = 0,
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

    fun runSync(): ISimpleScheduler
    fun runAsync(): ISimpleScheduler
    fun cancel()
}