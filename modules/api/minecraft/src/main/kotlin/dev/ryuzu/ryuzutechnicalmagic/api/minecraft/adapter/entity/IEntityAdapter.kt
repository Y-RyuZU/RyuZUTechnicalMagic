package dev.ryuzu.ryuzutechnicalmagic.api.minecraft.adapter.entity

import dev.ryuzu.ryuzutechnicalmagic.api.core.data.base.SerDoubleLocation
import dev.ryuzu.ryuzutechnicalmagic.api.core.data.base.SerDoubleVector
import dev.ryuzu.ryuzutechnicalmagic.api.core.data.base.SerIntLocation
import dev.ryuzu.ryuzutechnicalmagic.api.core.data.base.SerIntVector
import dev.ryuzu.ryuzutechnicalmagic.api.core.configuration.skill.effect.display.IConfiguredDisplay
import dev.ryuzu.ryuzutechnicalmagic.api.core.model.entity.IEntity
import dev.ryuzu.ryuzutechnicalmagic.api.core.model.entity.ILivingEntity

interface IEntityAdapter {
    fun spawnDisplay(configuredLocation: SerDoubleLocation, configuredDisplay: IConfiguredDisplay)
    fun getIntLocation(entity: IEntity): SerIntLocation
    fun getDoubleLocation(entity: IEntity): SerDoubleLocation
    fun getEyeLocation(entity: ILivingEntity): SerDoubleLocation
    fun getDirection(entity: IEntity): SerDoubleVector
    fun getEyeDirection(entity: ILivingEntity): SerDoubleVector

    fun teleport(location: SerIntLocation, entities: Set<IEntity>)
    fun teleport(location: SerIntLocation, vararg entities: IEntity) = teleport(location, entities.toSet())
    fun teleport(vector: SerIntVector, entities: Set<IEntity>)
    fun teleport(vector: SerIntVector, vararg entities: IEntity) = teleport(vector, entities.toSet())
}