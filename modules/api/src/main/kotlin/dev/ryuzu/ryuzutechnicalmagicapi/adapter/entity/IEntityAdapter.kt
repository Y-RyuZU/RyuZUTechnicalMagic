package dev.ryuzu.ryuzutechnicalmagicapi.adapter.entity

import dev.ryuzu.ryuzutechnicalmagicapi.model.configuration.base.ConfiguredDoubleLocation
import dev.ryuzu.ryuzutechnicalmagicapi.model.configuration.util.effect.display.IConfiguredDisplay

interface IEntityAdapter {
    fun spawnDisplay(configuredLocation: ConfiguredDoubleLocation, configuredDisplay: IConfiguredDisplay)
}