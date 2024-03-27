package com.github.ryuzu.ryuzutechnicalmagiccore.core.event.publisher

import com.github.ryuzu.ryuzutechnicalmagiccore.core.event.data.base.IEvent
import com.github.ryuzu.ryuzutechnicalmagiccore.core.event.handler.EventHandler
import com.github.ryuzu.ryuzutechnicalmagiccore.core.event.handler.IEventHandler
import org.koin.core.component.KoinComponent
import java.lang.reflect.Method

class EventPublisherImpl<T: IEvent>(
    private val listeners: MutableList<IEventHandler>,
    private val clazz: Class<T>
) : IEventPublisher, KoinComponent {
    private var methods: MutableList<Method> = mutableListOf()

    fun registerMethods() {
        val methods = mutableListOf<Method>()
        for (listener in listeners) {
            listener::class.java.methods.forEach { method ->
                if (method.isAnnotationPresent(EventHandler::class.java) && method.parameterTypes.firstOrNull() == clazz)
                    methods.add(method)
            }
        }
        this.methods = methods.sortedBy { it.getAnnotation(EventHandler::class.java).priority }.toMutableList()
    }

    fun unregisterMethods(listener: IEventHandler) {
        listener::class.java.methods.forEach { method ->
            if (method.isAnnotationPresent(EventHandler::class.java) && method.parameterTypes.firstOrNull() == clazz)
                methods.remove(method)
        }
    }

    override fun <T : IEvent> publish(event: T) {
        for (method in methods) {
            method.invoke(event)
            if(event.shouldNotify) break
        }
    }
}