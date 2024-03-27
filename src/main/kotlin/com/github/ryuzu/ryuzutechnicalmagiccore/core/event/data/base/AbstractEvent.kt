package com.github.ryuzu.ryuzutechnicalmagiccore.core.event.data.base


abstract class AbstractEvent : IEvent {
    override var shouldNotify: Boolean = true
    override var canChangeProperties: Boolean = true
}