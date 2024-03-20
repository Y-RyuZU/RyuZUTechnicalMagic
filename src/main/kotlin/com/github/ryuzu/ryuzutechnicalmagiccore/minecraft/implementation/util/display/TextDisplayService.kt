package com.github.ryuzu.ryuzutechnicalmagiccore.minecraft.implementation.util.display

import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.base.ConfiguredDoubleVector
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.base.ConfiguredIntLocation
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.util.display.IConfiguredDisplay
import com.github.ryuzu.ryuzutechnicalmagiccore.core.util.display.ITextDisplayService
import com.github.ryuzu.ryuzutechnicalmagiccore.minecraft.util.ColorUtility
import com.github.ryuzu.ryuzutechnicalmagiccore.minecraft.util.ConfiguredUtility.Companion.toLocation
import com.github.ryuzu.ryuzutechnicalmagiccore.minecraft.util.DisplayUtility
import net.kyori.adventure.text.Component
import org.bukkit.Bukkit
import org.bukkit.Color
import org.bukkit.entity.Display
import org.bukkit.entity.EntityType
import org.bukkit.entity.TextDisplay
import org.bukkit.util.Transformation
import org.joml.AxisAngle4f
import org.joml.Vector3f

class TextDisplayService : ITextDisplayService {
    override fun displayText(
        texts: IConfiguredDisplay.ConfiguredTextDisplay,
        configuredLocation: ConfiguredIntLocation
    ) {
        val location = configuredLocation.toLocation()
        val display = location.world.spawnEntity(location, EntityType.TEXT_DISPLAY) as TextDisplay
        DisplayUtility.setMeta(display, texts)
        display.text(Component.text { texts.texts })
        display.alignment = TextDisplay.TextAlignment.valueOf(texts.alignment)
        display.backgroundColor = ColorUtility.fromText(texts.background)
        display.lineWidth = texts.lineWidth
        display.textOpacity = texts.opacity
        display.isSeeThrough = texts.seeThrough
        display.isShadowed = texts.shadowed
    }
}