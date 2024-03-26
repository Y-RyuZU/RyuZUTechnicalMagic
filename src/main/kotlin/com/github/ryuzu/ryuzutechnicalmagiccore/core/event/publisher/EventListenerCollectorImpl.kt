package com.github.ryuzu.ryuzutechnicalmagiccore.core.event.publisher

import com.github.ryuzu.ryuzutechnicalmagiccore.core.event.data.*
import com.github.ryuzu.ryuzutechnicalmagiccore.core.event.handler.IEventHandler
import org.koin.core.annotation.Single

@Single
class EventListenerCollectorImpl : IEventListenerCollector {
    private val listeners: MutableList<IEventHandler> = mutableListOf()
    private val publishers: HashMap<Class<out IEvent>, EventPublisherImpl<out IEvent>> = hashMapOf(
        EntityDeathEvent::class.java to EventPublisherImpl(listeners, EntityDeathEvent::class.java),
        PlayerRightClickBlockEvent::class.java to EventPublisherImpl(listeners, PlayerRightClickBlockEvent::class.java),
        PlayerQuitEvent::class.java to EventPublisherImpl(listeners, PlayerQuitEvent::class.java),
        PlayerItemPickUpEvent::class.java to EventPublisherImpl(listeners, PlayerItemPickUpEvent::class.java),
        PlayerMaterialPickUpEvent::class.java to EventPublisherImpl(listeners, PlayerMaterialPickUpEvent::class.java),
        PlayerPortalReadyEvent::class.java to EventPublisherImpl(listeners, PlayerPortalReadyEvent::class.java),
    )

    override fun registerEventListener(listener: IEventHandler) {
        listeners.add(listener)
    }

    override fun unregisterEventListener(listener: IEventHandler) {
        listeners.remove(listener)

    }

    override fun publish(event: IEvent) {
        publishers[event::class.java]?.publish(event)
    }

    override fun registerAllMethods() {
        publishers.values.forEach {
            it.registerMethods()
        }
    }

    protected fun unregisterAllMethods(listener: IEventHandler) {
        publishers.values.forEach {
            it.unregisterMethods(listener)
        }
    }
}