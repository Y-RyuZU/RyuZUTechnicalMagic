package dev.ryuzu.ryuzutechnicalmagiccore.model.configuration.game.generator

import dev.ryuzu.ryuzutechnicalmagiccore.model.configuration.base.ConfiguredIntVector

data class ConfiguredItemGenerator(
    override val period: Int,
    override val offY: Double,
    override val radius: Double,
    override val maxStock: Int,
    override val multiply: Double,
    val rarity: Int, val unique: Double,
) : IConfiguredGenerator
