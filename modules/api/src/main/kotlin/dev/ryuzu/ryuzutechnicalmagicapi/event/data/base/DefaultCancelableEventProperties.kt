package dev.ryuzu.ryuzutechnicalmagicapi.event.data.base

data class DefaultCancelableEventProperties(
    val eventProps: DefaultEventProperties = DefaultEventProperties()
) : ICancelableEvent, IEvent by eventProps {
    override var isCancelled: Boolean = false
}