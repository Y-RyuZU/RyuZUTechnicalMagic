package dev.ryuzu.ryuzutechnicalmagicapi.model.entity

import dev.ryuzu.ryuzutechnicalmagicapi.model.configuration.base.ConfiguredDoubleLocation
import dev.ryuzu.ryuzutechnicalmagicapi.model.configuration.base.ConfiguredDoubleVector
import dev.ryuzu.ryuzutechnicalmagicapi.model.configuration.base.ConfiguredIntLocation
import dev.ryuzu.ryuzutechnicalmagicapi.model.configuration.base.ConfiguredIntVector
import java.util.*

interface IEntity {
    val id: UUID

    fun getDirection(): ConfiguredDoubleVector
    fun teleport(location: ConfiguredIntLocation)
    fun teleport(vector: ConfiguredIntVector)
    fun getIntLocation(): ConfiguredIntLocation
    fun getDoubleLocation(): ConfiguredDoubleLocation
}