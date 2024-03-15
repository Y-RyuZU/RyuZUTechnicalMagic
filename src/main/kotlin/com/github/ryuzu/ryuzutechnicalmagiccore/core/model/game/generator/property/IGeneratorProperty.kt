package com.github.ryuzu.ryuzutechnicalmagiccore.core.model.game.generator.property

import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.ConfiguredLocation

interface IGeneratorProperty {
    val location: ConfiguredLocation
    val period: Int
    val offY: Double
    val raidus: Double
    val MaxStock: Int
}