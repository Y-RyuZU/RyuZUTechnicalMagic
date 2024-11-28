package dev.ryuzu.ryuzutechnicalmagic.api.core.event.publisher

import dev.ryuzu.ryuzutechnicalmagic.api.core.event.data.base.IEvent
import dev.ryuzu.ryuzutechnicalmagic.api.core.event.handler.IEventHandler

interface IEventListenerCollector {
    fun registerEventListener(listener: IEventHandler)
    fun unregisterEventListener(listener: IEventHandler)
    fun publish(event: IEvent)
}