package dev.ryuzu.ryuzutechnicalmagic.api.core.event.data.base

import dev.ryuzu.ryuzutechnicalmagic.api.core.data.base.SerIntLocation

interface ILocationEvent : IEvent {
    var location: SerIntLocation
}