package com.github.ryuzu.ryuzutechnicalmagiccore.minecraft.implementation.util.wrapper.display

import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.base.ConfiguredIntLocation
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.util.display.IConfiguredDisplay
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.skill.service.ICoolTimeService
import com.github.ryuzu.ryuzutechnicalmagiccore.core.util.wrapper.display.ITextDisplayService
import com.github.ryuzu.ryuzutechnicalmagiccore.minecraft.util.ColorUtility
import com.github.ryuzu.ryuzutechnicalmagiccore.minecraft.util.ConfiguredUtility.Companion.toBlockLocation
import com.github.ryuzu.ryuzutechnicalmagiccore.minecraft.util.DisplayUtility
import net.kyori.adventure.text.Component
import org.bukkit.entity.EntityType
import org.bukkit.entity.TextDisplay
import org.koin.core.annotation.Single

@Single([ITextDisplayService::class])
class TextDisplayService : ITextDisplayService {
    override fun displayText(
        texts: IConfiguredDisplay.ConfiguredTextDisplay,
        configuredLocation: ConfiguredIntLocation
    ) {
        val location = configuredLocation.toBlockLocation()
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