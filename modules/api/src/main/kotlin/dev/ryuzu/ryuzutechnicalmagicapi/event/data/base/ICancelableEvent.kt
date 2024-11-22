package dev.ryuzu.ryuzutechnicalmagicapi.event.data.base


interface ICancelableEvent : IEvent {
    var isCancelled: Boolean
}