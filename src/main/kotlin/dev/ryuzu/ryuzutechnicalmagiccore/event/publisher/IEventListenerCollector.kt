package dev.ryuzu.ryuzutechnicalmagiccore.event.publisher

import dev.ryuzu.ryuzutechnicalmagiccore.event.data.base.IEvent
import dev.ryuzu.ryuzutechnicalmagiccore.event.handler.IEventHandler

interface IEventListenerCollector {
    fun registerEventListener(listener: IEventHandler)
    fun unregisterEventListener(listener: IEventHandler)
    fun publish(event: IEvent)
}