package dev.ryuzu.ryuzutechnicalmagic.api.core.model.entity

import dev.ryuzu.ryuzutechnicalmagic.api.core.model.configuration.base.ConfiguredDoubleLocation
import dev.ryuzu.ryuzutechnicalmagic.api.core.model.configuration.base.ConfiguredDoubleVector
import dev.ryuzu.ryuzutechnicalmagic.api.core.model.configuration.base.ConfiguredIntLocation
import dev.ryuzu.ryuzutechnicalmagic.api.core.configuration.data.base.ConfiguredIntVector
import java.util.*

interface IEntity {
    val id: UUID

    fun getDirection(): ConfiguredDoubleVector
    fun teleport(location: ConfiguredIntLocation)
    fun teleport(vector: ConfiguredIntVector)
    fun getIntLocation(): ConfiguredIntLocation
    fun getDoubleLocation(): ConfiguredDoubleLocation
}