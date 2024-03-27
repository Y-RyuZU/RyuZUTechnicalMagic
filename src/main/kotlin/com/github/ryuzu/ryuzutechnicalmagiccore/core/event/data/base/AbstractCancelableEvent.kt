package com.github.ryuzu.ryuzutechnicalmagiccore.core.event.data.base


abstract class AbstractCancelableEvent : ICancelableEvent, AbstractEvent() {
    override var isCancelled: Boolean = true
}