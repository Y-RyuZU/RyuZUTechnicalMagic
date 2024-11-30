package dev.ryuzu.ryuzutechnicalmagic.api.core.event.data.base


interface ICancelableEvent : IEvent {
    var isCancelled: Boolean
}