package dev.ryuzu.ryuzutechnicalmagic.minecraft.paper.util

import org.bukkit.Color

class ColorUtility {
    companion object {
        fun fromText(color: String): Color = when(color) {
            "AQUA" -> Color.AQUA
            "BLACK" -> Color.BLACK
            "BLUE" -> Color.BLUE
            "FUCHSIA" -> Color.FUCHSIA
            "GRAY" -> Color.GRAY
            "GREEN" -> Color.GREEN
            "LIME" -> Color.LIME
            "MAROON" -> Color.MAROON
            "NAVY" -> Color.NAVY
            "OLIVE" -> Color.OLIVE
            "ORANGE" -> Color.ORANGE
            "PURPLE" -> Color.PURPLE
            "RED" -> Color.RED
            "SILVER" -> Color.SILVER
            "TEAL" -> Color.TEAL
            "WHITE" -> Color.WHITE
            "YELLOW" -> Color.YELLOW
            else -> throw IllegalArgumentException("Invalid color name: $color")
        }
    }
}