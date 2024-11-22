package dev.ryuzu.ryuzutechnicalmagicapi.event.publisher

import dev.ryuzu.ryuzutechnicalmagicapi.event.data.base.IEvent
import dev.ryuzu.ryuzutechnicalmagicapi.event.handler.IEventHandler

interface IEventListenerCollector {
    fun registerEventListener(listener: IEventHandler)
    fun unregisterEventListener(listener: IEventHandler)
    fun publish(event: IEvent)
}