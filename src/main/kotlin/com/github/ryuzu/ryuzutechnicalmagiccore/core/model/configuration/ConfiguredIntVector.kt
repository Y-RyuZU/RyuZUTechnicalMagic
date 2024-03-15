package com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration

data class ConfiguredIntVector(val x: Int, val y: Int, val z: Int) {
    companion object {
        fun fromString(vector: String): ConfiguredIntVector {
            val split = vector.split("-")

            if (split.size != 3) {
                throw IllegalArgumentException("Invalid vector format, expected 3 parts but got ${split.size}")
            }

            val x = split[0].toIntOrNull()
            val y = split[1].toIntOrNull()
            val z = split[2].toIntOrNull()

            if(x == null || y == null || z == null) {
                throw NumberFormatException("Invalid vector format, expected integer values but got {${split[0]}, ${split[1]}, ${split[2]}}")
            }

            return ConfiguredIntVector(x, y, z)
        }
    }

    fun toLocation(world: String): ConfiguredLocation {
        return ConfiguredLocation(world, this)
    }
}
