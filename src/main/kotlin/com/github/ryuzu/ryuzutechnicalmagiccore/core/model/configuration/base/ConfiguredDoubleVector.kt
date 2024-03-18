package com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.base

data class ConfiguredDoubleVector(val x: Double, val y: Double, val z: Double) {
    companion object {
        fun fromString(vector: String): ConfiguredDoubleVector {
            val split = vector.split(",")

            if (split.size != 3) {
                throw IllegalArgumentException("Invalid vector format, expected 3 parts but got ${split.size}")
            }

            val x = split[0].toDoubleOrNull()
            val y = split[1].toDoubleOrNull()
            val z = split[2].toDoubleOrNull()

            if(x == null || y == null || z == null)
                throw NumberFormatException("Invalid vector format, expected double values but got {${split[0]}, ${split[1]}, ${split[2]}}")

            return ConfiguredDoubleVector(x, y, z)
        }
    }
}