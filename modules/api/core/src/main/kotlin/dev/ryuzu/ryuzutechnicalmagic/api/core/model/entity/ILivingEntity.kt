package dev.ryuzu.ryuzutechnicalmagic.api.core.model.entity

import dev.ryuzu.ryuzutechnicalmagic.api.core.data.base.SerDoubleLocation
import dev.ryuzu.ryuzutechnicalmagic.api.core.data.base.SerDoubleVector

interface ILivingEntity : IEntity {
    fun getEyeLocation(): SerDoubleLocation
    fun getEyeDirection(): SerDoubleVector
}