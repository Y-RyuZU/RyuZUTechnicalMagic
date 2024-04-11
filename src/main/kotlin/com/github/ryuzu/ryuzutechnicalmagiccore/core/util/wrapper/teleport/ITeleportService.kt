package com.github.ryuzu.ryuzutechnicalmagiccore.core.util.wrapper.teleport

import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.base.ConfiguredIntLocation
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.base.ConfiguredIntVector
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.player.IEntity
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.player.IPlayer
import org.koin.core.component.KoinComponent
import java.util.UUID

interface ITeleportService {
    fun teleport(location: ConfiguredIntLocation, entities: Set<IEntity>)
    fun teleport(location: ConfiguredIntLocation, vararg entities: IEntity) = teleport(location, entities.toSet())
    fun teleport(vector: ConfiguredIntVector, entities: Set<IEntity>)
    fun teleport(vector: ConfiguredIntVector, vararg entities: IEntity) = teleport(vector, entities.toSet())
}