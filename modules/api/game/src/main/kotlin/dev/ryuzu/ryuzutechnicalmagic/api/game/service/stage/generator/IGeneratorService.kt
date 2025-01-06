package dev.ryuzu.ryuzutechnicalmagic.api.game.service.stage.generator

import dev.ryuzu.ryuzutechnicalmagic.api.core.data.base.SerDoubleLocation
import dev.ryuzu.ryuzutechnicalmagic.api.core.model.entity.IEntity

interface IGeneratorService {
    fun stop()
    fun generateItem(location: SerDoubleLocation, rarity: Int): IEntity
    fun generateStar(location: SerDoubleLocation, amount: Int, scatter: Double = 0.0): StarStockData
    fun generateHyper(location: SerDoubleLocation)
}