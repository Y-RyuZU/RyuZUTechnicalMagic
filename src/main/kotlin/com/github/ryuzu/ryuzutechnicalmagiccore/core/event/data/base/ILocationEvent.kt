package com.github.ryuzu.ryuzutechnicalmagiccore.core.event.data.base

import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.base.ConfiguredIntLocation

interface ILocationEvent : IEvent {
    var location: ConfiguredIntLocation
}