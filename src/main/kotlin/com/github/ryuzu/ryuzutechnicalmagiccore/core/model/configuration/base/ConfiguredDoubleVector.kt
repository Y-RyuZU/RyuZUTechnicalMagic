package com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.base

import com.fasterxml.jackson.annotation.JsonCreator
import kotlin.math.sqrt
import kotlin.random.Random

data class ConfiguredDoubleVector(val x: Double, val y: Double, val z: Double) {

    @JsonCreator
    constructor(vector: String) : this(
        fromStringPart(vector, 0),
        fromStringPart(vector, 1),
        fromStringPart(vector, 2)
    )

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

    fun toIntVector(): ConfiguredIntVector {
        return ConfiguredIntVector(x.toInt(), y.toInt(), z.toInt())
    }

    fun toLocation(world: String): ConfiguredDoubleLocation {
        return ConfiguredDoubleLocation(world, this)
    }
}