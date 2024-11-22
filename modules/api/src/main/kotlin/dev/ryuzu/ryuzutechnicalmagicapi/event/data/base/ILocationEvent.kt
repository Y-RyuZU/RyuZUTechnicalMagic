package dev.ryuzu.ryuzutechnicalmagicapi.event.data.base

import dev.ryuzu.ryuzutechnicalmagicapi.model.configuration.base.ConfiguredIntLocation

interface ILocationEvent : IEvent {
    var location: ConfiguredIntLocation
}