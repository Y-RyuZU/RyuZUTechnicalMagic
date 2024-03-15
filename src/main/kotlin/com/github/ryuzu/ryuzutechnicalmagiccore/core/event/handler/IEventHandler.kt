package com.github.ryuzu.ryuzutechnicalmagiccore.core.event.handler

import com.github.ryuzu.ryuzutechnicalmagiccore.core.event.data.IEvent

interface IEventHandler {
//    val eventHandlers: MutableMap<EventType, MutableList<IEvent>> = mutableMapOf()
    fun handleEvent(evnet: IEvent)
}