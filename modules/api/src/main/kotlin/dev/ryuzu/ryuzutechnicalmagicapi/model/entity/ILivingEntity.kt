package dev.ryuzu.ryuzutechnicalmagicapi.model.entity

import dev.ryuzu.ryuzutechnicalmagicapi.model.configuration.base.ConfiguredDoubleLocation
import dev.ryuzu.ryuzutechnicalmagicapi.model.configuration.base.ConfiguredDoubleVector
import dev.ryuzu.ryuzutechnicalmagicapi.model.entity.effect.StatusEffectId
import dev.ryuzu.ryuzutechnicalmagicapi.model.entity.effect.StatusEffectState

interface ILivingEntity : IEntity {
    fun getEyeLocation(): ConfiguredDoubleLocation
    fun getEyeDirection(): ConfiguredDoubleVector
}