package com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.base

import com.fasterxml.jackson.annotation.JsonCreator

data class ConfiguredIntVector(val x: Int, val y: Int, val z: Int) {

    @JsonCreator
    constructor(vector: String) : this(
        x = fromStringPart(vector, 0),
        y = fromStringPart(vector, 1),
        z = fromStringPart(vector, 2)
    )

    companion object {

        private fun fromStringPart(vector: String, index: Int): Int {
            val split = vector.split(",")

            if (split.size != 3) {
                throw IllegalArgumentException("Invalid vector format, expected 3 parts but got ${split.size}")
            }

            return split[index].toIntOrNull()
                ?: throw NumberFormatException("Invalid vector format, expected integer values but got {${split[0]}, ${split[1]}, ${split[2]}}")
        }
    }

    fun toLocation(world: String): ConfiguredIntLocation {
        return ConfiguredIntLocation(world, this)
    }

    fun toDoubleVector(): ConfiguredDoubleVector {
        return ConfiguredDoubleVector(x.toDouble(), y.toDouble(), z.toDouble())
    }
}