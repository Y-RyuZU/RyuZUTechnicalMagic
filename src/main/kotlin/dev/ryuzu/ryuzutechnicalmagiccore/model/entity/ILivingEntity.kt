package dev.ryuzu.ryuzutechnicalmagiccore.model.entity

import dev.ryuzu.ryuzutechnicalmagiccore.model.configuration.base.ConfiguredDoubleLocation
import dev.ryuzu.ryuzutechnicalmagiccore.model.configuration.base.ConfiguredDoubleVector
import dev.ryuzu.ryuzutechnicalmagiccore.model.entity.effect.StatusEffectId
import dev.ryuzu.ryuzutechnicalmagiccore.model.entity.effect.StatusEffectState

interface ILivingEntity : IEntity {
    fun getEyeLocation(): ConfiguredDoubleLocation
    fun getEyeDirection(): ConfiguredDoubleVector
}