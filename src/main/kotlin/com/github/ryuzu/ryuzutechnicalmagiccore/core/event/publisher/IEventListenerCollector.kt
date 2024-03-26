package com.github.ryuzu.ryuzutechnicalmagiccore.core.event.publisher

import com.github.ryuzu.ryuzutechnicalmagiccore.core.event.data.IEvent
import com.github.ryuzu.ryuzutechnicalmagiccore.core.event.handler.IEventHandler

interface IEventListenerCollector {
    fun registerEventListener(listener: IEventHandler)
    fun unregisterEventListener(listener: IEventHandler)
    fun publish(event: IEvent)
    fun registerAllMethods()
}