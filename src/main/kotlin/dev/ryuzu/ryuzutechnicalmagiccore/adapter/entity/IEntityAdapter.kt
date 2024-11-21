package dev.ryuzu.ryuzutechnicalmagiccore.adapter.entity

import dev.ryuzu.ryuzutechnicalmagiccore.model.configuration.base.ConfiguredDoubleLocation
import dev.ryuzu.ryuzutechnicalmagiccore.model.configuration.util.effect.display.IConfiguredDisplay

interface IEntityAdapter {
    fun spawnDisplay(configuredLocation: ConfiguredDoubleLocation, configuredDisplay: IConfiguredDisplay)
}