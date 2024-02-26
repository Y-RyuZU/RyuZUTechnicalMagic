package com.github.ryuzu.ryuzutechnicalmagiccore.core.domain.model.configuration

import kotlin.jvm.Throws

data class ConfiguredIntVector(val x: Int, val y: Int, val z: Int) {
    companion object {
        @Throws(IllegalArgumentException::class, NumberFormatException::class)
        fun fromString(vector: String): ConfiguredIntVector {
            val split = vector.split("-")
            if (split.size != 3) throw IllegalArgumentException("Invalid vector format")
            return ConfiguredIntVector(split[0].toInt(), split[1].toInt(), split[2].toInt())
        }
    }

    fun toLocation(world: String): ConfiguredLocation {
        return ConfiguredLocation(world, this)
    }
}
