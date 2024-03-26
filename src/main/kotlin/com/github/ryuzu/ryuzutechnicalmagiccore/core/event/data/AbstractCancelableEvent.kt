package com.github.ryuzu.ryuzutechnicalmagiccore.core.event.data


abstract class AbstractCancelableEvent : ICancelableEvent, AbstractEvent() {
    override var isCancelled: Boolean = true
}