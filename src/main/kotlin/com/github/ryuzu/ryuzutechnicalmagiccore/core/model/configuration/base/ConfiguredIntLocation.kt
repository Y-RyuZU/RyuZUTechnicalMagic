package com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.base

import com.fasterxml.jackson.annotation.JsonCreator

data class ConfiguredIntLocation(val world: String, val vector: ConfiguredIntVector) {

    @JsonCreator
    constructor(location: String) : this(
        world = fromStringWorld(location),
        vector = fromStringVector(location)
    )

    companion object {

        private fun fromStringWorld(location: String): String {
            val split = location.split(",")
            if (split.size != 4) {
                throw IllegalArgumentException("Invalid location format, expected 4 parts but got ${split.size}")
            }
            return split[0].takeIf { it.isNotEmpty() }
                ?: throw IllegalArgumentException("Invalid world name, should not be empty.")
        }

        private fun fromStringVector(location: String): ConfiguredIntVector {
            val split = location.split(",")
            if (split.size != 4) {
                throw IllegalArgumentException("Invalid location format, expected 4 parts but got ${split.size}")
            }
            val vectorString = split.subList(1, split.size).joinToString(",")
            return try {
                ConfiguredIntVector(vectorString)
            } catch (e: NumberFormatException) {
                throw NumberFormatException("Unable to parse vector values in location string.")
            }
        }
    }

    fun toDoubleLocation(): ConfiguredDoubleLocation {
        return ConfiguredDoubleLocation(world, vector.toDoubleVector())
    }
}