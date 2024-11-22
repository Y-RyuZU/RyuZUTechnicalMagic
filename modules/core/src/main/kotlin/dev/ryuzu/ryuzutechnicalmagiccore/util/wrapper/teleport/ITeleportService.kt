package dev.ryuzu.ryuzutechnicalmagiccore.util.wrapper.teleport

import dev.ryuzu.ryuzutechnicalmagiccore.model.configuration.base.ConfiguredIntLocation
import dev.ryuzu.ryuzutechnicalmagiccore.model.configuration.base.ConfiguredIntVector
import dev.ryuzu.ryuzutechnicalmagiccore.model.entity.IEntity

interface ITeleportService {
    fun teleport(location: ConfiguredIntLocation, entities: Set<IEntity>)
    fun teleport(location: ConfiguredIntLocation, vararg entities: IEntity) = teleport(location, entities.toSet())
    fun teleport(vector: ConfiguredIntVector, entities: Set<IEntity>)
    fun teleport(vector: ConfiguredIntVector, vararg entities: IEntity) = teleport(vector, entities.toSet())
}