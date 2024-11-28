package dev.ryuzu.ryuzutechnicalmagic.api.core.model.entity

import dev.ryuzu.ryuzutechnicalmagic.api.core.model.configuration.base.ConfiguredDoubleLocation
import dev.ryuzu.ryuzutechnicalmagic.api.core.model.configuration.base.ConfiguredDoubleVector

interface ILivingEntity : IEntity {
    fun getEyeLocation(): ConfiguredDoubleLocation
    fun getEyeDirection(): ConfiguredDoubleVector
}