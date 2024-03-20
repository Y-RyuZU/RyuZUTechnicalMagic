package com.github.ryuzu.ryuzutechnicalmagiccore.core.util.scheduler

import java.util.*

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

    fun end(task: () -> Unit): ISimpleScheduler

    fun runSync()
    fun runAsync()
    fun cancel()
}