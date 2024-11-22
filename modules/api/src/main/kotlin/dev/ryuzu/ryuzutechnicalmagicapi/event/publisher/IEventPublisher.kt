package dev.ryuzu.ryuzutechnicalmagicapi.event.publisher

import dev.ryuzu.ryuzutechnicalmagicapi.event.data.base.IEvent
import dev.ryuzu.ryuzutechnicalmagicapi.event.handler.IEventHandler

interface IEventPublisher {
    fun registerMethods(listener: IEventHandler)
    fun unregisterMethods(listener: IEventHandler)
    fun <T> publish(event: T) where T : IEvent
}