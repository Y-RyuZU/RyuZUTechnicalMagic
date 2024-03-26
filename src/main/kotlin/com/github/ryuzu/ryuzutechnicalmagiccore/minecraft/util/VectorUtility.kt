package com.github.ryuzu.ryuzutechnicalmagiccore.minecraft.util

import org.bukkit.util.Vector
import kotlin.math.acos

class VectorUtility {
    companion object {
        fun Vector.getDegreeFrom3Points(a: Vector, c: Vector): Double {
            val b = this
            val ab = b.clone().subtract(a)
            val bc = c.clone().subtract(b)
            val cosTheta = ab.dot(bc) / (ab.length() * bc.length())
            return Math.toDegrees(acos(cosTheta))
        }
    }
}