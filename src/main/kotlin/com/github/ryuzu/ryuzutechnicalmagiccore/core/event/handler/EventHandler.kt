package com.github.ryuzu.ryuzutechnicalmagiccore.core.event.handler

@Target(AnnotationTarget.FUNCTION)
annotation class EventHandler(
    val priority: Int = 100,
    val ignoreCancelled: Boolean = false
)
