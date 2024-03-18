package com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.game.generator

import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.base.ConfiguredDoubleVector
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.base.ConfiguredIntVector
import com.github.ryuzu.ryuzutechnicalmagiccore.core.util.MathUtility.Companion.nextGaussian
import kotlin.math.PI
import kotlin.math.cos
import kotlin.math.sin
import kotlin.random.Random

interface IConfiguredGenerator {
    val vector: ConfiguredIntVector
    val period: Int
    val offY: Double
    val radius: Double
    val maxStock: Int
    val multiply: Double

    fun getGeneratePoint(): ConfiguredDoubleVector {
        val xRadius = Random.nextGaussian() * radius
        val zRadius = Random.nextGaussian() * radius
        val angle = Random.nextDouble() * 2 * PI
        return ConfiguredDoubleVector(vector.x + xRadius * cos(angle), vector.y + zRadius * sin(angle), vector.z + Random.nextDouble(offY))
    }
}