package dev.ryuzu.ryuzutechnicalmagic.api.minecraft.adapter.location

import dev.ryuzu.ryuzutechnicalmagic.api.core.model.configuration.base.ConfiguredDoubleLocation
import dev.ryuzu.ryuzutechnicalmagic.api.core.model.configuration.base.ConfiguredDoubleVector
import dev.ryuzu.ryuzutechnicalmagic.api.core.model.configuration.base.ConfiguredIntLocation
import dev.ryuzu.ryuzutechnicalmagic.api.core.model.entity.IEntity
import dev.ryuzu.ryuzutechnicalmagic.api.core.model.entity.ILivingEntity

interface ILocationService {
    fun getIntLocation(entity: IEntity): ConfiguredIntLocation
    fun getDoubleLocation(entity: IEntity): ConfiguredDoubleLocation
    fun getEyeLocation(entity: ILivingEntity): ConfiguredDoubleLocation
    fun getDirection(entity: IEntity): ConfiguredDoubleVector
    fun getEyeDirection(entity: ILivingEntity): ConfiguredDoubleVector
    fun getNearbyLivingEntities(location: ConfiguredDoubleLocation, radius: Double, predicate: ((ILivingEntity) -> Boolean)? = null): Set<ILivingEntity>
    fun getNearbyAllyLivingEntities(location: ConfiguredDoubleLocation, radius: Double, caster: ILivingEntity?): Set<ILivingEntity>
    fun getNearbyEnemyLivingEntities(location: ConfiguredDoubleLocation, radius: Double, caster: ILivingEntity?): Set<ILivingEntity>
    fun canThrough(location: ConfiguredDoubleLocation, direction: ConfiguredDoubleVector, maxDistance: Double = 1.0): Boolean
}