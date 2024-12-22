package dev.ryuzu.ryuzutechnicalmagic.api.minecraft.adapter.location

import dev.ryuzu.ryuzutechnicalmagic.api.core.data.base.SerDoubleLocation
import dev.ryuzu.ryuzutechnicalmagic.api.core.data.base.SerDoubleVector
import dev.ryuzu.ryuzutechnicalmagic.api.core.model.entity.IEntity
import dev.ryuzu.ryuzutechnicalmagic.api.core.model.entity.ILivingEntity
import dev.ryuzu.ryuzutechnicalmagic.api.core.model.entity.IPlayer

interface ILocationAdapter {
    fun getNearbyPlayers(location: SerDoubleLocation, radius: Double): Set<IPlayer>
    fun getNearbyLivingEntities(location: SerDoubleLocation, radius: Double, predicate: ((ILivingEntity) -> Boolean)? = null): Set<ILivingEntity>
    fun getNearbyAllyLivingEntities(location: SerDoubleLocation, radius: Double, caster: ILivingEntity?): Set<ILivingEntity>
    fun getNearbyEnemyLivingEntities(location: SerDoubleLocation, radius: Double, caster: ILivingEntity?): Set<ILivingEntity>
    fun canThrough(location: SerDoubleLocation, direction: SerDoubleVector, maxDistance: Double = 1.0): Boolean
}