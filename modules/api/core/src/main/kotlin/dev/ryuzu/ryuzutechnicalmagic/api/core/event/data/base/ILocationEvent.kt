package dev.ryuzu.ryuzutechnicalmagic.api.core.event.data.base

import dev.ryuzu.ryuzutechnicalmagic.api.core.model.configuration.base.ConfiguredIntLocation

interface ILocationEvent : IEvent {
    var location: ConfiguredIntLocation
}