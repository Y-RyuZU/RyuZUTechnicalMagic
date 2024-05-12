package com.github.ryuzu.ryuzutechnicalmagiccore.core.model.entity

import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.base.ConfiguredDoubleLocation
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.base.ConfiguredDoubleVector
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.base.ConfiguredIntLocation
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.base.ConfiguredIntVector
import java.util.*

interface IEntity {
    val id: UUID

    fun getDirection(): ConfiguredDoubleVector
    fun teleport(location: ConfiguredIntLocation)
    fun teleport(vector: ConfiguredIntVector)
    fun getIntLocation(): ConfiguredIntLocation
    fun getDoubleLocation(): ConfiguredDoubleLocation
}