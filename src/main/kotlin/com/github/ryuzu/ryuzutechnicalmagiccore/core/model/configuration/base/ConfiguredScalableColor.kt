package com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.base

data class ConfiguredScalableColor(val color: ConfiguredColor, val size: Float = 1.0f) {
    companion object {
        fun fromString(vector: String): ConfiguredScalableColor {
            val split = vector.split(",")

            if (split.size != 4) {
                throw IllegalArgumentException("Invalid vector format, expected 4 parts but got ${split.size}")
            }

            val size = split[3].toFloatOrNull()
                ?: throw NumberFormatException("Invalid vector format, expected float value but got ${split[3]}")

            val rgbString = split.take(3).joinToString("-")
            val color = ConfiguredColor.fromString(rgbString)
            return ConfiguredScalableColor(color, size)
        }
    }
}