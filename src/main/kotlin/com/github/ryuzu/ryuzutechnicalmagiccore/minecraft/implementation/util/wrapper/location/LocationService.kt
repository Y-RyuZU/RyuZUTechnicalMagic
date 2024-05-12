package com.github.ryuzu.ryuzutechnicalmagiccore.minecraft.implementation.util.wrapper.location

import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.base.ConfiguredDoubleLocation
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.base.ConfiguredDoubleVector
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.base.ConfiguredIntLocation
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.entity.IEntity
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.entity.ILivingEntity
import com.github.ryuzu.ryuzutechnicalmagiccore.core.util.wrapper.location.AbstractLocationService
import com.github.ryuzu.ryuzutechnicalmagiccore.core.util.wrapper.location.ILocationService
import com.github.ryuzu.ryuzutechnicalmagiccore.minecraft.util.ConfiguredUtility.Companion.toDoubleConfigured
import com.github.ryuzu.ryuzutechnicalmagiccore.minecraft.util.ConfiguredUtility.Companion.toIntConfigured
import com.github.ryuzu.ryuzutechnicalmagiccore.minecraft.util.ConfiguredUtility.Companion.toLocation
import com.github.ryuzu.ryuzutechnicalmagiccore.minecraft.util.ConfiguredUtility.Companion.toVector
import com.github.ryuzu.ryuzutechnicalmagiccore.minecraft.util.EntityUtility.Companion.toEntity
import com.github.ryuzu.ryuzutechnicalmagiccore.minecraft.util.EntityUtility.Companion.toLivingEntity
import org.bukkit.FluidCollisionMode
import org.bukkit.util.RayTraceResult
import org.koin.core.annotation.Single

@Single([ILocationService::class])
class LocationService : AbstractLocationService() {
    override fun getIntLocation(entity: IEntity): ConfiguredIntLocation =
        entity.toEntity().location.toIntConfigured()

    override fun getDoubleLocation(entity: IEntity): ConfiguredDoubleLocation =
        entity.toEntity().location.toDoubleConfigured()

    override fun getEyeLocation(entity: ILivingEntity): ConfiguredDoubleLocation =
        entity.toLivingEntity().eyeLocation.toDoubleConfigured()

    override fun getDirection(entity: IEntity): ConfiguredDoubleVector =
        entity.toEntity().location.direction.toDoubleConfigured()

    override fun getEyeDirection(entity: ILivingEntity): ConfiguredDoubleVector =
        entity.toLivingEntity().eyeLocation.direction.toDoubleConfigured()

    override fun getNearbyLivingEntities(
        location: ConfiguredDoubleLocation,
        radius: Double,
        predicate: ((ILivingEntity) -> Boolean)?
    ): Set<ILivingEntity> {
        val entities = location.toLocation().getNearbyLivingEntities(radius)
            .map { entityManager.getLivingEntity(it.uniqueId) }
        return if (predicate == null) entities.toSet() else entities.filter { predicate(it) }.toSet()
    }

    override fun canThrough(location: ConfiguredDoubleLocation, direction: ConfiguredDoubleVector, maxDistance: Double): Boolean {
        val result: RayTraceResult? = location.toLocation().world.rayTraceBlocks(
            location.toLocation(),
            direction.toVector(),
            maxDistance,
            FluidCollisionMode.NEVER,
            true
        )
        return result == null || result.hitBlock == null
    }
}