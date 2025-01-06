package dev.ryuzu.ryuzutechnicalmagic.api.core.model.entity

import dev.ryuzu.ryuzutechnicalmagic.api.core.data.base.SerDoubleLocation
import dev.ryuzu.ryuzutechnicalmagic.api.core.data.base.SerDoubleVector
import dev.ryuzu.ryuzutechnicalmagic.api.core.data.base.SerIntLocation
import dev.ryuzu.ryuzutechnicalmagic.api.core.data.base.SerIntVector
import java.util.*

interface IEntity {
    val id: UUID

    fun getDirection(): SerDoubleVector
    fun teleport(location: SerIntLocation)
    fun teleport(vector: SerIntVector)
    fun getIntLocation(): SerIntLocation
    fun getDoubleLocation(): SerDoubleLocation
}