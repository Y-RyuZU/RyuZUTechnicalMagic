package dev.ryuzu.ryuzutechnicalmagicapi.util.wrapper.teleport

import dev.ryuzu.ryuzutechnicalmagicapi.model.configuration.base.ConfiguredIntLocation
import dev.ryuzu.ryuzutechnicalmagicapi.model.configuration.base.ConfiguredIntVector
import dev.ryuzu.ryuzutechnicalmagicapi.model.entity.IEntity

interface ITeleportService {
    fun teleport(location: ConfiguredIntLocation, entities: Set<IEntity>)
    fun teleport(location: ConfiguredIntLocation, vararg entities: IEntity) = teleport(location, entities.toSet())
    fun teleport(vector: ConfiguredIntVector, entities: Set<IEntity>)
    fun teleport(vector: ConfiguredIntVector, vararg entities: IEntity) = teleport(vector, entities.toSet())
}