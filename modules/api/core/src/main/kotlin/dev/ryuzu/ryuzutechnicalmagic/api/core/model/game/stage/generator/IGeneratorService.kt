package dev.ryuzu.ryuzutechnicalmagic.api.core.model.game.stage.generator

import dev.ryuzu.ryuzutechnicalmagic.api.core.model.configuration.base.ConfiguredDoubleLocation
import dev.ryuzu.ryuzutechnicalmagic.api.core.model.entity.IEntity

interface IGeneratorService {
    fun stop()
    fun generateItem(location: ConfiguredDoubleLocation, rarity: Int): IEntity
    fun generateStar(location: ConfiguredDoubleLocation, amount: Int, scatter: Double = 0.0): StarStockData
    fun generateHyper(location: ConfiguredDoubleLocation)
}