package com.github.ryuzu.ryuzutechnicalmagiccore.core.event.data


interface ICancelableEvent : IEvent {
    var isCancelled: Boolean
}