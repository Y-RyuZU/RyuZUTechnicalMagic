package dev.ryuzu.ryuzutechnicalmagic.api.minecraft.adapter.location

import dev.ryuzu.ryuzutechnicalmagic.api.core.configuration.data.base.ConfiguredDoubleLocation
import dev.ryuzu.ryuzutechnicalmagic.api.core.configuration.data.base.ConfiguredDoubleVector
import dev.ryuzu.ryuzutechnicalmagic.api.core.model.entity.ILivingEntity
import dev.ryuzu.ryuzutechnicalmagic.api.core.model.entity.IPlayer

interface ILocationAdapter {
    fun getNearbyPlayers(location: ConfiguredDoubleLocation, radius: Double): Set<IPlayer>
    fun getNearbyLivingEntities(location: ConfiguredDoubleLocation, radius: Double, predicate: ((ILivingEntity) -> Boolean)? = null): Set<ILivingEntity>
    fun getNearbyAllyLivingEntities(location: ConfiguredDoubleLocation, radius: Double, caster: ILivingEntity?): Set<ILivingEntity>
    fun getNearbyEnemyLivingEntities(location: ConfiguredDoubleLocation, radius: Double, caster: ILivingEntity?): Set<ILivingEntity>
    fun canThrough(location: ConfiguredDoubleLocation, direction: ConfiguredDoubleVector, maxDistance: Double = 1.0): Boolean
}