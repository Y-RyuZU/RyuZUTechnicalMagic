package dev.ryuzu.ryuzutechnicalmagic.core.impl.event.handler

@Target(AnnotationTarget.FUNCTION)
annotation class EventHandler(
    val priority: Int = 100,
    val ignoreCancelled: Boolean = false
)
