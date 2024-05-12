package com.github.ryuzu.ryuzutechnicalmagiccore.core.util.wrapper.location

import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.base.ConfiguredDoubleLocation
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.base.ConfiguredDoubleVector
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.base.ConfiguredIntLocation
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.entity.IEntity
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.entity.ILivingEntity

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