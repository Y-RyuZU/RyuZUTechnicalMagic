package dev.ryuzu.ryuzutechnicalmagic.minecraft.paper.implementation.util.wrapper.display

import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.base.ConfiguredIntLocation
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.util.display.IConfiguredDisplay
import com.github.ryuzu.ryuzutechnicalmagiccore.core.util.wrapper.display.ITextDisplayService
import dev.ryuzu.ryuzutechnicalmagic.minecraft.paper.util.ColorUtility
import dev.ryuzu.ryuzutechnicalmagic.minecraft.paper.util.ConfiguredUtility.Companion.toBlockLocation
import dev.ryuzu.ryuzutechnicalmagic.minecraft.paper.util.DisplayUtility
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
        display.alignment = TextDisplay.TextAlignment.valueOf(texts.alignment.uppercase())
        display.backgroundColor = ColorUtility.fromText(texts.background)
        display.lineWidth = texts.lineWidth
        display.textOpacity = texts.opacity
        display.isSeeThrough = texts.seeThrough
        display.isShadowed = texts.shadowed
    }
}