package com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.game.generator

import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.base.ConfiguredIntVector

data class ConfiguredStarGenerator(
    override val vector: ConfiguredIntVector,
    override val period: Int,
    override val offY: Double,
    override val radius: Double,
    override val maxStock: Int,
    override val multiply: Double,
    val min: Int, val max: Int,
) : IConfiguredGenerator
