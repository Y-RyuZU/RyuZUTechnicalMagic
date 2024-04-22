package com.github.ryuzu.ryuzutechnicalmagiccore.core.model.game.stage.generator

import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.base.ConfiguredDoubleLocation
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.player.IEntity
import org.koin.core.component.KoinComponent
import java.util.UUID

interface IGeneratorService : KoinComponent {
    fun stop()
    fun generateItem(location: ConfiguredDoubleLocation, rarity: Int): IEntity
    fun generateStar(location: ConfiguredDoubleLocation, amount: Int, scatter: Double = 0.0): StarStockData
    fun generateHyper(location: ConfiguredDoubleLocation)
}