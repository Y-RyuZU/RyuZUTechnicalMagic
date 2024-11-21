package dev.ryuzu.ryuzutechnicalmagiccore.event.data.base


interface ICancelableEvent : IEvent {
    var isCancelled: Boolean
}