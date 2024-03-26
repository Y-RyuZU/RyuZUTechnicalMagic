package com.github.ryuzu.ryuzutechnicalmagiccore.core.model.game.stage.generator

import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.base.ConfiguredDoubleLocation
import org.koin.core.component.KoinComponent
import java.util.UUID

interface IGeneratorService : KoinComponent {
    fun stop()
    fun generateItem(location: ConfiguredDoubleLocation, rarity: Int): UUID
    fun generateStar(location: ConfiguredDoubleLocation, amount: Int, scatter: Double = 0.0): StarStockData
    fun generateHyper(location: ConfiguredDoubleLocation)
}