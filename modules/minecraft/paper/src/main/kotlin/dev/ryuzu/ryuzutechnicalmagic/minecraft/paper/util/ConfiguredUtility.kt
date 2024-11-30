package dev.ryuzu.ryuzutechnicalmagic.minecraft.paper.util

import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.base.ConfiguredDoubleLocation
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.base.ConfiguredDoubleVector
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.base.ConfiguredIntLocation
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.base.ConfiguredIntVector
import org.bukkit.Bukkit
import org.bukkit.Location
import org.bukkit.util.Vector

class ConfiguredUtility {
    companion object {
        fun Vector.toDoubleConfigured(): ConfiguredDoubleVector = ConfiguredDoubleVector(x, y, z)
        fun Vector.toIntConfigured(): ConfiguredIntVector = ConfiguredIntVector(blockX, blockY, blockZ)
        fun Location.toDoubleConfigured(): ConfiguredDoubleLocation = ConfiguredDoubleLocation(world.name, toVector().toDoubleConfigured())
        fun Location.toIntConfigured(): ConfiguredIntLocation = ConfiguredIntLocation(world.name, toVector().toIntConfigured())
        fun ConfiguredDoubleVector.toVector(): Vector = Vector(x(), y(), z())
        fun ConfiguredIntVector.toVector(): Vector = Vector(x.toDouble(), y.toDouble(), z.toDouble())
        fun ConfiguredDoubleLocation.toLocation(): Location = Location(Bukkit.getWorld(world), vector.x(), vector.y(), vector.z())
        fun ConfiguredIntLocation.toBlockLocation(): Location = Location(Bukkit.getWorld(world), vector.x.toDouble(), vector.y.toDouble(), vector.z.toDouble())
        fun ConfiguredIntLocation.toMiddleLocation(): Location = Location(Bukkit.getWorld(world), vector.x.toDouble() + 0.5, vector.y.toDouble() + 0.5, vector.z.toDouble() + 0.5)
    }
}