package com.github.ryuzu.ryuzutechnicalmagiccore.core.util.scheduler

import java.util.SortedSet

abstract class AbstractSimpleScheduler : ISimpleScheduler {
    override val tasks: SortedSet<TaskUnit> = sortedSetOf(compareBy { it.delay + it.period })
    override var endTask: () -> Unit = {}
    override var currentTick: Long = 0
}