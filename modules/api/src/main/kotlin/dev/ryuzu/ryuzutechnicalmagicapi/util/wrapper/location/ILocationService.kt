package dev.ryuzu.ryuzutechnicalmagicapi.util.wrapper.location

import dev.ryuzu.ryuzutechnicalmagicapi.model.configuration.base.ConfiguredDoubleLocation
import dev.ryuzu.ryuzutechnicalmagicapi.model.configuration.base.ConfiguredDoubleVector
import dev.ryuzu.ryuzutechnicalmagicapi.model.configuration.base.ConfiguredIntLocation
import dev.ryuzu.ryuzutechnicalmagicapi.model.entity.IEntity
import dev.ryuzu.ryuzutechnicalmagicapi.model.entity.ILivingEntity

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