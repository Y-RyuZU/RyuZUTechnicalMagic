package dev.ryuzu.ryuzutechnicalmagiccore.model.game.stage.generator

import dev.ryuzu.ryuzutechnicalmagiccore.model.configuration.base.ConfiguredDoubleLocation
import dev.ryuzu.ryuzutechnicalmagiccore.model.entity.IEntity
import org.koin.core.component.KoinComponent

interface IGeneratorService : KoinComponent {
    fun stop()
    fun generateItem(location: ConfiguredDoubleLocation, rarity: Int): IEntity
    fun generateStar(location: ConfiguredDoubleLocation, amount: Int, scatter: Double = 0.0): dev.ryuzu.ryuzutechnicalmagiccore.model.game.stage.generator.StarStockData
    fun generateHyper(location: ConfiguredDoubleLocation)
}