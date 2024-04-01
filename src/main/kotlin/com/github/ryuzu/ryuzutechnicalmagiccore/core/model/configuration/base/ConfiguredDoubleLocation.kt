package com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.base

import com.fasterxml.jackson.annotation.JsonCreator

data class ConfiguredDoubleLocation(val world: String, val vector: ConfiguredDoubleVector) {

    @JsonCreator
    constructor(location: String) : this(
        world = fromStringWorld(location),
        vector = fromStringVector(location)
    )

    override fun toString(): String {
        return "$world,${vector}"
    }

    fun toIntLocation(): ConfiguredIntLocation {
        return ConfiguredIntLocation(world, vector.toIntVector())
    }

    companion object {
        private fun fromStringWorld(location: String): String {
            val split = location.split(",")
            if (split.size != 4) {
                throw IllegalArgumentException("Invalid location format, expected 4 parts but got ${split.size}")
            }
            return split[0].takeIf { it.isNotEmpty() }
                ?: throw IllegalArgumentException("Invalid world name, should not be empty.")
        }

        private fun fromStringVector(location: String): ConfiguredDoubleVector {
            val split = location.split(",")
            if (split.size != 4) {
                throw IllegalArgumentException("Invalid location format, expected 4 parts but got ${split.size}")
            }
            val vectorString = split.subList(1, split.size).joinToString(",")
            return try {
                ConfiguredDoubleVector(vectorString)
            } catch (e: NumberFormatException) {
                throw NumberFormatException("Unable to parse vector values in location string.")
            }
        }
    }
}