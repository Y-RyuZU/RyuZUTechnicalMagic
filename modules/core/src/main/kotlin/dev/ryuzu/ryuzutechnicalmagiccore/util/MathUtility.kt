package dev.ryuzu.ryuzutechnicalmagiccore.util

import kotlin.math.PI
import kotlin.math.ln
import kotlin.math.sqrt
import kotlin.random.Random

class MathUtility {
    companion object {
        fun Random.nextGaussian(): Double {
            val u1 = this.nextDouble()
            val u2 = this.nextDouble()
            return sqrt(-2.0 * ln(u1)) * kotlin.math.cos(2.0 * PI * u2)
        }
    }
}