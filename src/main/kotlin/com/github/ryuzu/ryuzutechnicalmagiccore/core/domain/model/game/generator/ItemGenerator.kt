package com.github.ryuzu.ryuzutechnicalmagiccore.core.domain.model.game.generator

import com.github.ryuzu.ryuzutechnicalmagiccore.core.domain.model.configuration.ConfiguredLocation

data class ItemGenerator(
    override val location: ConfiguredLocation,
    override val period: Int,
    override val offY: Double,
    override val raidus: Double,
    override val MaxStock: Int,
    val rarity: Int, val unique: Double,
) : IGenerator
