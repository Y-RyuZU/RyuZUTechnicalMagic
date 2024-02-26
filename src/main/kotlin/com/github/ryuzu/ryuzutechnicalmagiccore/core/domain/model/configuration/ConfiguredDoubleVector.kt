package com.github.ryuzu.ryuzutechnicalmagiccore.core.domain.model.configuration

import kotlin.jvm.Throws

data class ConfiguredDoubleVector(val x: Double, val y: Double, val z: Double) {
    companion object {
        @Throws(IllegalArgumentException::class, NumberFormatException::class)
        fun fromString(vector: String): ConfiguredDoubleVector {
            val split = vector.split("-")
            if (split.size != 3) throw IllegalArgumentException("Invalid vector format")
            return ConfiguredDoubleVector(split[0].toDouble(), split[1].toDouble(), split[2].toDouble())
        }
    }
}
