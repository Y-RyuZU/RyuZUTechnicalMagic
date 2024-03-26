package com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.base

import com.fasterxml.jackson.annotation.JsonCreator
import net.kyori.adventure.text.format.TextColor

data class ConfiguredColor(val r: Int, val g: Int, val b: Int) {

    @JsonCreator
    constructor(color: String) : this(
        r = fromStringPart(color, 0),
        g = fromStringPart(color, 1),
        b = fromStringPart(color, 2)
    )

    companion object {

        private fun fromStringPart(color: String, index: Int): Int {
            val split = color.split(",")

            if (split.size != 3) {
                throw IllegalArgumentException("Invalid color format, expected 3 parts but got ${split.size}")
            }

            return split[index].toIntOrNull()?.takeIf { it in 0..255 }
                ?: throw NumberFormatException("Invalid color format, expected integer values in range 0..255 but got {${split[0]}, ${split[1]}, ${split[2]}}")
        }
    }

    fun toHex(): String = String.format("#%02X%02X%02X", r, g, b)

    fun toTextColor(): TextColor = TextColor.color(r, g, b)
}