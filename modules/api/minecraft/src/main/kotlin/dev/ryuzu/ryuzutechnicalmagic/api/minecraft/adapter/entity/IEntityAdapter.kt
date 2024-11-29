package dev.ryuzu.ryuzutechnicalmagic.api.minecraft.adapter.entity

import dev.ryuzu.ryuzutechnicalmagic.api.core.configuration.base.ConfiguredDoubleLocation
import dev.ryuzu.ryuzutechnicalmagic.api.core.configuration.base.ConfiguredDoubleVector
import dev.ryuzu.ryuzutechnicalmagic.api.core.configuration.base.ConfiguredIntLocation
import dev.ryuzu.ryuzutechnicalmagic.api.core.configuration.base.ConfiguredIntVector
import dev.ryuzu.ryuzutechnicalmagic.api.core.configuration.util.effect.display.IConfiguredDisplay
import dev.ryuzu.ryuzutechnicalmagic.api.core.model.entity.IEntity
import dev.ryuzu.ryuzutechnicalmagic.api.core.model.entity.ILivingEntity

interface IEntityAdapter {
    fun spawnDisplay(configuredLocation: ConfiguredDoubleLocation, configuredDisplay: IConfiguredDisplay)
    fun getIntLocation(entity: IEntity): ConfiguredIntLocation
    fun getDoubleLocation(entity: IEntity): ConfiguredDoubleLocation
    fun getEyeLocation(entity: ILivingEntity): ConfiguredDoubleLocation
    fun getDirection(entity: IEntity): ConfiguredDoubleVector
    fun getEyeDirection(entity: ILivingEntity): ConfiguredDoubleVector

    fun teleport(location: ConfiguredIntLocation, entities: Set<IEntity>)
    fun teleport(location: ConfiguredIntLocation, vararg entities: IEntity) = teleport(location, entities.toSet())
    fun teleport(vector: ConfiguredIntVector, entities: Set<IEntity>)
    fun teleport(vector: ConfiguredIntVector, vararg entities: IEntity) = teleport(vector, entities.toSet())
}