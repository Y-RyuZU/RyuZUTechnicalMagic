package dev.ryuzu.ryuzutechnicalmagic.api.game.data.generator

data class ConfiguredStarGenerator(
    override val period: Int,
    override val offY: Double,
    override val radius: Double,
    override val maxStock: Int,
    override val multiply: Double,
    val min: Int, val max: Int,
) : dev.ryuzu.ryuzutechnicalmagic.api.game.data.generator.IConfiguredGenerator
