package dev.ryuzu.ryuzutechnicalmagiccore.event.data.base

import dev.ryuzu.ryuzutechnicalmagiccore.model.configuration.base.ConfiguredIntLocation

interface ILocationEvent : IEvent {
    var location: ConfiguredIntLocation
}