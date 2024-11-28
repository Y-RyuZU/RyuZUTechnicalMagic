package dev.ryuzu.ryuzutechnicalmagic.api.core.event.publisher

import dev.ryuzu.ryuzutechnicalmagic.api.core.event.data.base.IEvent
import dev.ryuzu.ryuzutechnicalmagic.api.core.event.handler.IEventHandler

interface IEventPublisher {
    fun registerMethods(listener: IEventHandler)
    fun unregisterMethods(listener: IEventHandler)
    fun <T> publish(event: T) where T : IEvent
}