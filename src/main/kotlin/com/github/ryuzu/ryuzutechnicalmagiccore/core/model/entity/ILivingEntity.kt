package com.github.ryuzu.ryuzutechnicalmagiccore.core.model.entity

import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.base.ConfiguredDoubleLocation
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.base.ConfiguredDoubleVector

interface ILivingEntity : IEntity {
    fun getEyeLocation(): ConfiguredDoubleLocation
    fun getEyeDirection(): ConfiguredDoubleVector
}