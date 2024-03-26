package com.github.ryuzu.ryuzutechnicalmagiccore.core.event.publisher

import com.github.ryuzu.ryuzutechnicalmagiccore.core.event.data.IEvent

interface IEventPublisher {
    fun <T> publish(event: T) where T : IEvent
}