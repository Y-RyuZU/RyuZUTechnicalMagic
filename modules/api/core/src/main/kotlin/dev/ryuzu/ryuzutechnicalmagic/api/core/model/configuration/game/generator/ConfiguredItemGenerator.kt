package dev.ryuzu.ryuzutechnicalmagic.api.core.model.configuration.game.generator

data class ConfiguredItemGenerator(
    override val period: Int,
    override val offY: Double,
    override val radius: Double,
    override val maxStock: Int,
    override val multiply: Double,
    val rarity: Int, val unique: Double,
) : IConfiguredGenerator
