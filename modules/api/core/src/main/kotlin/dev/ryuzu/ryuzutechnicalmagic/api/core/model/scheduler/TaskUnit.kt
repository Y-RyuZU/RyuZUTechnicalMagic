package dev.ryuzu.ryuzutechnicalmagic.api.core.model.scheduler

data class TaskUnit(
    val delay: Long = 0,
    val period: Long = 1,
    val condition: (Long) -> Boolean = { true },
    val task: (ISimpleScheduler, Long) -> Unit
)
