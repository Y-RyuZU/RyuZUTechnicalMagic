package com.github.ryuzu.ryuzutechnicalmagiccore.core.event.data.base

class DefaultCancelableEventProperties(eventProps: DefaultEventProperties = DefaultEventProperties()) : ICancelableEvent, IEvent by eventProps {
    override var isCancelled: Boolean = false
}