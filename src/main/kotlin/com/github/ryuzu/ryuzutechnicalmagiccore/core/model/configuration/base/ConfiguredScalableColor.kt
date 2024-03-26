package com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.base

import com.fasterxml.jackson.annotation.JsonCreator

data class ConfiguredScalableColor(val color: ConfiguredColor, val size: Float = 1.0f) {

    @JsonCreator
    constructor(scalableColor: String) : this(
        color = fromStringColor(scalableColor),
        size = fromStringSize(scalableColor)
    )

    companion object {

        private fun fromStringColor(scalableColor: String): ConfiguredColor {
            val split = scalableColor.split(",")
            if (split.size != 4) {
                throw IllegalArgumentException("Invalid scalable color format, expected 4 parts but got ${split.size}")
            }
            val rgbString = split.take(3).joinToString("-")
            return ConfiguredColor(rgbString)
        }

        private fun fromStringSize(scalableColor: String): Float {
            val split = scalableColor.split(",")
            if (split.size != 4) {
                throw IllegalArgumentException("Invalid scalable color format, expected 4 parts but got ${split.size}")
            }
            return split[3].toFloatOrNull()
                ?: throw NumberFormatException("Invalid scalable color format, expected float value but got ${split[3]}")
        }
    }
}