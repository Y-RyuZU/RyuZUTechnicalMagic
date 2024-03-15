package com.github.ryuzu.ryuzutechnicalmagiccore.core.model.game.generator.property

import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.ConfiguredLocation

data class ItemGeneratorProperty(
    override val location: ConfiguredLocation,
    override val period: Int,
    override val offY: Double,
    override val raidus: Double,
    override val MaxStock: Int,
    val rarity: Int, val unique: Double,
) : IGeneratorProperty
