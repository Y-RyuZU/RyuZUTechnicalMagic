package com.github.ryuzu.ryuzutechnicalmagiccore.minecraft.util

import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.base.ConfiguredDoubleVector
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.util.display.IConfiguredDisplay
import org.bukkit.entity.Display
import org.bukkit.util.Transformation
import org.joml.Vector3f

class DisplayUtility {
    companion object {
        fun setMeta(display: Display,config: IConfiguredDisplay) {
            display.billboard = Display.Billboard.valueOf(config.billboard)
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
                config.transformation.translation.toVector(),
                config.transformation.yawPitchRoll,
                config.transformation.scale.toVector(),
                config.transformation.yawPitchRoll2
            )
        }


        private fun ConfiguredDoubleVector.toVector(): Vector3f {
            return Vector3f(this.x.toFloat(), this.y.toFloat(), this.z.toFloat())
        }
    }
}