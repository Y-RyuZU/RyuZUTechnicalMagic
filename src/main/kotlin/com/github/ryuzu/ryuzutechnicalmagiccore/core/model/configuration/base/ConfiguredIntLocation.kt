package com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.base

data class ConfiguredIntLocation(val world: String, val vector: ConfiguredIntVector) {
    companion object {
        fun fromString(location: String): ConfiguredIntLocation {
            val split = location.split(",")

            if (split.size != 4) {
                throw IllegalArgumentException("Invalid location format, expected 4 parts but got ${split.size}")
            }

            // Ensure non-empty world name
            val world = split[0].takeIf { it.isNotEmpty() }
                ?: throw IllegalArgumentException("Invalid world name, should not be empty.")

            val vectorString = split.subList(1, split.size).joinToString(",")

            // Handle NumberFormatException from ConfiguredIntVector.fromString
            val vector = try {
                ConfiguredIntVector.fromString(vectorString)
            } catch (e: NumberFormatException) {
                throw NumberFormatException("Unable to parse vector values in location string.")
            }

            return ConfiguredIntLocation(world, vector)
        }
    }
}
