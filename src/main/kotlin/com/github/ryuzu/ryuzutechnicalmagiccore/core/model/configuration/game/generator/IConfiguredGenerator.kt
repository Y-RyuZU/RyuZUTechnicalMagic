package com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.game.generator

import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.base.ConfiguredDoubleVector
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.base.ConfiguredIntVector
import com.github.ryuzu.ryuzutechnicalmagiccore.core.util.MathUtility.Companion.nextGaussian
import kotlin.math.PI
import kotlin.math.cos
import kotlin.math.sin
import kotlin.random.Random

interface IConfiguredGenerator {
    val period: Int
    val offY: Double
    val radius: Double
    val maxStock: Int
    val multiply: Double

    fun getGeneratePoint(vector: ConfiguredIntVector): ConfiguredDoubleVector {
        val xRadius = Random.nextGaussian() * radius
        val zRadius = Random.nextGaussian() * radius
        return ConfiguredDoubleVector(vector.x + xRadius, vector.y + offY, vector.z + zRadius)
    }
}