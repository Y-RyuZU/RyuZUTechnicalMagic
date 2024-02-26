package com.github.ryuzu.ryuzutechnicalmagiccore.core.domain.model.game.generator

import com.github.ryuzu.ryuzutechnicalmagiccore.core.domain.model.configuration.ConfiguredLocation

interface IGenerator {
    val location: ConfiguredLocation
    val period: Int
    val offY: Double
    val raidus: Double
    val MaxStock: Int
}