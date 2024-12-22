package dev.ryuzu.ryuzutechnicalmagic.api.game.service.stage.generator

import dev.ryuzu.ryuzutechnicalmagic.api.core.model.configuration.base.ConfiguredDoubleLocation
import dev.ryuzu.ryuzutechnicalmagic.api.core.model.entity.IEntity

interface IGeneratorService {
    fun stop()
    fun generateItem(location: ConfiguredDoubleLocation, rarity: Int): IEntity
    fun generateStar(location: ConfiguredDoubleLocation, amount: Int, scatter: Double = 0.0): dev.ryuzu.ryuzutechnicalmagic.api.game.service.stage.generator.StarStockData
    fun generateHyper(location: ConfiguredDoubleLocation)
}