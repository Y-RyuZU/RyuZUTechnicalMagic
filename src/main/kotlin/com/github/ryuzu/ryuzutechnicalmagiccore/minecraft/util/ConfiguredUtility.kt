package com.github.ryuzu.ryuzutechnicalmagiccore.minecraft.util

import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.base.ConfiguredDoubleLocation
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.base.ConfiguredDoubleVector
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.base.ConfiguredIntVector
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.base.ConfiguredIntLocation
import org.bukkit.Bukkit
import org.bukkit.Location
import org.bukkit.util.Vector

class ConfiguredUtility {
    companion object {
        fun Vector.toDoubleConfigured(): ConfiguredDoubleVector = ConfiguredDoubleVector(x, y, z)
        fun Vector.toIntConfigured(): ConfiguredIntVector = ConfiguredIntVector(blockX, blockY, blockZ)
        fun Location.toDoubleConfigured(): ConfiguredDoubleLocation = ConfiguredDoubleLocation(world.name, toVector().toDoubleConfigured())
        fun Location.toIntConfigured(): ConfiguredIntLocation = ConfiguredIntLocation(world.name, toVector().toIntConfigured())
        fun ConfiguredDoubleVector.toVector(): Vector = Vector(x, y, z)
        fun ConfiguredIntVector.toVector(): Vector = Vector(x.toDouble(), y.toDouble(), z.toDouble())
        fun ConfiguredDoubleLocation.toLocation(): Location = Location(Bukkit.getWorld(world), vector.x, vector.y, vector.z)
        fun ConfiguredIntLocation.toLocation(): Location = Location(Bukkit.getWorld(world), vector.x.toDouble(), vector.y.toDouble(), vector.z.toDouble())
    }
}