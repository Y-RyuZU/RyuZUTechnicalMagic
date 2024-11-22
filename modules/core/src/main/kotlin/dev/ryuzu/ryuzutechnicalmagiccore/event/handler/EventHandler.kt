package dev.ryuzu.ryuzutechnicalmagiccore.event.handler

@Target(AnnotationTarget.FUNCTION)
annotation class EventHandler(
    val priority: Int = 100,
    val ignoreCancelled: Boolean = false
)
