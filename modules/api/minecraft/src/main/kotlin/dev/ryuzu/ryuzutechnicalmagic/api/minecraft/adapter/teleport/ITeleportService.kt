package dev.ryuzu.ryuzutechnicalmagic.api.minecraft.adapter.teleport

import dev.ryuzu.ryuzutechnicalmagic.api.core.model.configuration.base.ConfiguredIntLocation
import dev.ryuzu.ryuzutechnicalmagic.api.core.model.configuration.base.ConfiguredIntVector
import dev.ryuzu.ryuzutechnicalmagic.api.core.model.entity.IEntity

interface ITeleportService {
    fun teleport(location: ConfiguredIntLocation, entities: Set<IEntity>)
    fun teleport(location: ConfiguredIntLocation, vararg entities: IEntity) = teleport(location, entities.toSet())
    fun teleport(vector: ConfiguredIntVector, entities: Set<IEntity>)
    fun teleport(vector: ConfiguredIntVector, vararg entities: IEntity) = teleport(vector, entities.toSet())
}