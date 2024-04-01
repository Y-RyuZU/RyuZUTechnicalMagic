package com.github.ryuzu.ryuzutechnicalmagiccore.minecraft.util

import org.bukkit.util.Vector
import kotlin.math.acos

class VectorUtility {
    companion object {
        fun Vector.getDegreeFrom3Points(a: Vector, c: Vector): Double {
            val b = this
            val ba = b.clone().subtract(a)
            val bc = b.clone().subtract(c)
            val cosTheta = ba.dot(bc) / (ba.length() * bc.length())
            return Math.toDegrees(acos(cosTheta))
        }
    }
}