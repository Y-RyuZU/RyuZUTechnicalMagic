package dev.ryuzu.ryuzutechnicalmagic.minecraft.paper.util

import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.base.ConfiguredDoubleVector
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.util.display.IConfiguredDisplay
import org.bukkit.entity.Display
import org.bukkit.util.Transformation
import org.joml.Vector3f

class DisplayUtility {
    companion object {
        fun setMeta(display: Display,config: IConfiguredDisplay) {
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
}