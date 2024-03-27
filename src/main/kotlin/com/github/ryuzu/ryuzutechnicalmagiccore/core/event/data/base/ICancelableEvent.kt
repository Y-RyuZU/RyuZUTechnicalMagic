package com.github.ryuzu.ryuzutechnicalmagiccore.core.event.data.base


interface ICancelableEvent : IEvent {
    var isCancelled: Boolean
}