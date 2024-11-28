package dev.ryuzu.ryuzutechnicalmagic.api.minecraft.adapter.entity

import dev.ryuzu.ryuzutechnicalmagic.api.core.model.configuration.base.ConfiguredDoubleLocation
import dev.ryuzu.ryuzutechnicalmagic.api.core.model.configuration.util.effect.display.IConfiguredDisplay

interface IEntityAdapter {
    fun spawnDisplay(configuredLocation: ConfiguredDoubleLocation, configuredDisplay: IConfiguredDisplay)
}