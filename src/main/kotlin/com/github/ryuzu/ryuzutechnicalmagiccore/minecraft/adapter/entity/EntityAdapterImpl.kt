package com.github.ryuzu.ryuzutechnicalmagiccore.minecraft.adapter.entity

import com.github.ryuzu.ryuzutechnicalmagiccore.core.adapter.entity.IEntityAdapter
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.base.ConfiguredDoubleLocation
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.util.effect.display.IConfiguredDisplay
import com.github.ryuzu.ryuzutechnicalmagiccore.minecraft.model.item.IItemManager
import com.github.ryuzu.ryuzutechnicalmagiccore.minecraft.util.ColorUtility
import com.github.ryuzu.ryuzutechnicalmagiccore.minecraft.util.ConfiguredUtility.Companion.toLocation
import net.kyori.adventure.text.Component
import org.bukkit.entity.Display
import org.bukkit.entity.EntityType
import org.bukkit.entity.ItemDisplay
import org.bukkit.entity.TextDisplay
import org.bukkit.util.Transformation
import org.koin.core.annotation.Single
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

@Single([IEntityAdapter::class], true)
class EntityAdapterImpl : IEntityAdapter, KoinComponent {
    private val itemManager: IItemManager by inject()

    override fun spawnDisplay(configuredLocation: ConfiguredDoubleLocation, configuredDisplay: IConfiguredDisplay) {
        val location = configuredLocation.toLocation()

        val entityType: EntityType = when (configuredDisplay) {
            is IConfiguredDisplay.ConfiguredItemDisplay -> EntityType.ITEM_DISPLAY
            is IConfiguredDisplay.ConfiguredBlockDisplay -> EntityType.BLOCK_DISPLAY
            is IConfiguredDisplay.ConfiguredTextDisplay -> EntityType.TEXT_DISPLAY

            else -> throw IllegalArgumentException("Unknown display type")
        }

        val display = location.world.spawnEntity(location, entityType) as Display

        setMeta(display, configuredDisplay)

        when (configuredDisplay) {
            is IConfiguredDisplay.ConfiguredItemDisplay -> {
                display as ItemDisplay

                display.itemStack = itemManager.getItemStack(configuredDisplay.item)
            }

            is IConfiguredDisplay.ConfiguredBlockDisplay -> {
                TODO()
            }

            is IConfiguredDisplay.ConfiguredTextDisplay -> {
                display as TextDisplay

                display.text(Component.text { configuredDisplay.texts })
                display.alignment = TextDisplay.TextAlignment.valueOf(configuredDisplay.alignment.uppercase())
                display.backgroundColor = ColorUtility.fromText(configuredDisplay.background)
                display.lineWidth = configuredDisplay.lineWidth
                display.textOpacity = configuredDisplay.opacity
                display.isSeeThrough = configuredDisplay.seeThrough
                display.isShadowed = configuredDisplay.shadowed
            }
        }
    }

    private fun setMeta(display: Display, config: IConfiguredDisplay) {
        display.billboard = Display.Billboard.valueOf(config.billboard.uppercase())
        display.brightness = Display.Brightness(config.blockLight, config.skyLight)
        display.displayHeight = config.height
        display.displayWidth = config.width
        display.glowColorOverride = ColorUtility.fromText(config.glowColor)
        display.interpolationDelay = config.interpolationDelay
        display.interpolationDuration = config.interpolationDuration
        display.teleportDuration = config.teleportDuration
        display.shadowRadius = config.shadowRadius
        display.shadowStrength = config.shadowStrength
        display.viewRange = config.viewRange
        display.transformation = Transformation(
            config.transformation.translation.toFloat(),
            config.transformation.yawPitchRoll,
            config.transformation.scale.toFloat(),
            config.transformation.yawPitchRoll2
        )
    }
}