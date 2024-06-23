package com.github.ryuzu.ryuzutechnicalmagiccore.core.event.publisher

import com.github.ryuzu.ryuzutechnicalmagiccore.core.event.data.*
import com.github.ryuzu.ryuzutechnicalmagiccore.core.event.data.base.IEvent
import com.github.ryuzu.ryuzutechnicalmagiccore.core.event.data.block.PlayerBlockBreakEvent
import com.github.ryuzu.ryuzutechnicalmagiccore.core.event.data.block.PlayerBlockPlaceEvent
import com.github.ryuzu.ryuzutechnicalmagiccore.core.event.data.click.PlayerLeftClickAirEvent
import com.github.ryuzu.ryuzutechnicalmagiccore.core.event.data.click.PlayerLeftClickBlockEvent
import com.github.ryuzu.ryuzutechnicalmagiccore.core.event.data.click.PlayerRightClickAirEvent
import com.github.ryuzu.ryuzutechnicalmagiccore.core.event.data.click.PlayerRightClickBlockEvent
import com.github.ryuzu.ryuzutechnicalmagiccore.core.event.data.damage.EntityDamageEvent
import com.github.ryuzu.ryuzutechnicalmagiccore.core.event.data.damage.EntityDeathEvent
import com.github.ryuzu.ryuzutechnicalmagiccore.core.event.data.item.PlayerDropEvent
import com.github.ryuzu.ryuzutechnicalmagiccore.core.event.data.item.PlayerPickUpEvent
import com.github.ryuzu.ryuzutechnicalmagiccore.core.event.data.skill.*
import com.github.ryuzu.ryuzutechnicalmagiccore.core.event.handler.IEventHandler
import org.koin.core.annotation.Single
import org.reflections.Reflections
import org.reflections.scanners.Scanners
import org.reflections.scanners.SubTypesScanner
import org.reflections.util.ConfigurationBuilder

@Single([IEventListenerCollector::class])
class EventListenerCollectorImpl : IEventListenerCollector {
    private val listeners: MutableList<IEventHandler> = mutableListOf()
    private val eventClasses =
        Reflections(
            ConfigurationBuilder()
                .forPackages("com.github.ryuzu.ryuzutechnicalmagiccore.core.event.data")
                .addScanners(Scanners.SubTypes)
        ).getSubTypesOf(IEvent::class.java)

    private val publishers: Map<Class<out IEvent>, EventPublisherImpl<out IEvent>> =
        eventClasses.associateWith { EventPublisherImpl(it) }

    override fun registerEventListener(listener: IEventHandler) {
        listeners.add(listener)
        publishers.values.forEach {
            it.registerMethods(listener)
        }
    }

    override fun unregisterEventListener(listener: IEventHandler) {
        listeners.remove(listener)
        publishers.values.forEach {
            it.unregisterMethods(listener)
        }
    }

    override fun publish(event: IEvent) {
        publishers[event::class.java]?.publish(event)
    }
}