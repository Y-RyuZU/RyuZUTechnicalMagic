package com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.base

import com.fasterxml.jackson.annotation.JsonCreator
import org.joml.Vector3d
import org.joml.Vector3f
import kotlin.math.sqrt
import kotlin.random.Random

data class ConfiguredDoubleVector(var x: Double = 0.0, val y: Double = 0.0, val z: Double = 0.0) : Vector3d(x, y, z) {

    @JsonCreator
    constructor(vector: String) : this(
        fromStringPart(vector, 0),
        fromStringPart(vector, 1),
        fromStringPart(vector, 2)
    )

    constructor(vector: Vector3d) : this(vector.x, vector.y, vector.z)

    constructor() : this(0.0, 1.0, 0.0)

    override fun toString(): String {
        return "$x,$y,$z"
    }

    fun toIntVector(): ConfiguredIntVector {
        return ConfiguredIntVector(x.toInt(), y.toInt(), z.toInt())
    }

    fun toLocation(world: String): ConfiguredDoubleLocation {
        return ConfiguredDoubleLocation(world, this)
    }

    fun toFloat(): Vector3f {
        return Vector3f(x.toFloat(), y.toFloat(), z.toFloat())
    }

    companion object {
        private fun fromStringPart(vector: String, index: Int): Double {
            val split = vector.split(",")

            if (split.size != 3) {
                throw IllegalArgumentException("Invalid vector format, expected 3 parts but got ${split.size}")
            }

            return split[index].toDoubleOrNull()
                ?: throw NumberFormatException("Invalid vector format, expected double values but got {${split[0]}, ${split[1]}, ${split[2]}}")
        }

        fun random(): ConfiguredDoubleVector {
            val x = Random.nextDouble() * 2 - 1
            val y = Random.nextDouble() * 2 - 1
            val z = Random.nextDouble() * 2 - 1

            // 生成したランダム値の大きさ（長さ）を計算
            val magnitude = sqrt(x*x + y*y + z*z)

            // 大きさで各成分を割り、正規化されたベクトルを生成
            return ConfiguredDoubleVector(x/magnitude, y/magnitude, z/magnitude)
        }
    }
}