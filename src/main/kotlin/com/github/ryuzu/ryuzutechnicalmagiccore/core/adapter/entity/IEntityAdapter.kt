package com.github.ryuzu.ryuzutechnicalmagiccore.core.adapter.entity

import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.base.ConfiguredDoubleLocation
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.util.effect.display.IConfiguredDisplay

interface IEntityAdapter {
    fun spawnDisplay(configuredLocation: ConfiguredDoubleLocation, configuredDisplay: IConfiguredDisplay)
}