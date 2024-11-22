package dev.ryuzu.ryuzutechnicalmagiccore.event.publisher

import dev.ryuzu.ryuzutechnicalmagiccore.event.data.base.IEvent
import dev.ryuzu.ryuzutechnicalmagiccore.event.handler.IEventHandler

interface IEventPublisher {
    fun registerMethods(listener: IEventHandler)
    fun unregisterMethods(listener: IEventHandler)
    fun <T> publish(event: T) where T : IEvent
}