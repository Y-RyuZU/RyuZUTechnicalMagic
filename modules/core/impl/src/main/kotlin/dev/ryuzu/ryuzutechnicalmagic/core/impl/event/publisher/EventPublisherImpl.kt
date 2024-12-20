package dev.ryuzu.ryuzutechnicalmagic.core.impl.event.publisher

import dev.ryuzu.ryuzutechnicalmagic.api.core.event.data.base.IEvent
import dev.ryuzu.ryuzutechnicalmagic.api.core.event.handler.EventHandler
import dev.ryuzu.ryuzutechnicalmagic.api.core.event.handler.IEventHandler
import dev.ryuzu.ryuzutechnicalmagic.api.core.event.publisher.IEventPublisher
import org.koin.core.component.KoinComponent
import java.lang.reflect.Method

class EventPublisherImpl<T : IEvent>(
    private val clazz: Class<T>
) : IEventPublisher, KoinComponent {
    private var methods: LinkedHashMap<Method, IEventHandler> = linkedMapOf()

    override fun registerMethods(listener: IEventHandler) {
        listener::class.java.methods.forEach { method ->
            if (
                method.isAnnotationPresent(EventHandler::class.java) &&
                method.parameterTypes.firstOrNull()?.isAssignableFrom(clazz) == true
            )
                methods[method] = listener
        }
        this.methods = methods.entries.sortedBy { it.key.getAnnotation(EventHandler::class.java).priority }
            .associate { it.toPair() }.toMutableMap() as LinkedHashMap<Method, IEventHandler>
    }

    override fun unregisterMethods(listener: IEventHandler) {
        val entriesToRemove =
            methods.filter { it.value == listener && it.key.isAnnotationPresent(EventHandler::class.java) && it.key.parameterTypes.firstOrNull() == clazz }
        entriesToRemove.forEach { (key, _) -> methods.remove(key) }
    }

    override fun <T : IEvent> publish(event: T) {
        for ((method, listener) in methods) {
            method.invoke(listener, event)
            if (!event.shouldNotify) break
        }
    }
}