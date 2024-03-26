package com.github.ryuzu.ryuzutechnicalmagiccore.core.event.data


abstract class AbstractEvent : IEvent {
    override var shouldNotify: Boolean = true
    override var canChangeProperties: Boolean = true

    protected fun <T> getSetter(oldValue: T, newValue: T): T =
        if (canChangeProperties) oldValue else newValue
}