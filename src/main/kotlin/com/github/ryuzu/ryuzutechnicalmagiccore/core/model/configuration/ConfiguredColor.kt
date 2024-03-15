package com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration

import net.kyori.adventure.text.format.TextColor
import org.bukkit.Color
import kotlin.jvm.Throws

data class ConfiguredColor(val r: Int, val g: Int, val b: Int) {
    companion object {
        fun fromString(vector: String): ConfiguredColor {
            val split = vector.split("-")

            if (split.size != 3) {
                throw IllegalArgumentException("Invalid vector format, expected 3 parts but got ${split.size}")
            }

            val r = split[0].toIntOrNull()?.takeIf { it in 0..255 }
            val g = split[1].toIntOrNull()?.takeIf { it in 0..255 }
            val b = split[2].toIntOrNull()?.takeIf { it in 0..255 }

            if (r == null || g == null || b == null) {
                throw NumberFormatException("Invalid vector format, expected integer values in range 0..255 but got {${split[0]}, ${split[1]}, ${split[2]}}")
            }

            return ConfiguredColor(r, g, b)
        }
    }

    fun toHex(): String = String.format("#%02X%02X%02X", r, g, b)

    fun toTextColor(): TextColor = TextColor.color(r, g, b)
}