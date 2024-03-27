package com.github.ryuzu.ryuzutechnicalmagiccore.core.event.data.base

class DefaultEventProperties : IEvent {
    override var shouldNotify: Boolean = true
    override var canChangeProperties: Boolean = true
}