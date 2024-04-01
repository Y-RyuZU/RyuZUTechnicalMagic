package com.github.ryuzu.ryuzutechnicalmagiccore.core.event.publisher

import com.github.ryuzu.ryuzutechnicalmagiccore.core.event.data.base.IEvent
import com.github.ryuzu.ryuzutechnicalmagiccore.core.event.handler.IEventHandler

interface IEventPublisher {
    fun registerMethods(listener: IEventHandler)
    fun unregisterMethods(listener: IEventHandler)
    fun <T> publish(event: T) where T : IEvent
}