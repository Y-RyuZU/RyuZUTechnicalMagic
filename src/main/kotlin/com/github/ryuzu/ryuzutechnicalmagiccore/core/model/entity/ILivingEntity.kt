package com.github.ryuzu.ryuzutechnicalmagiccore.core.model.entity

import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.base.ConfiguredDoubleLocation
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.base.ConfiguredDoubleVector
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.entity.effect.IStatusEffectContainer
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.entity.effect.StatusEffectId
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.entity.effect.StatusEffectState

interface ILivingEntity : IEntity {
    val statusEffectContainer: IStatusEffectContainer

    fun getEyeLocation(): ConfiguredDoubleLocation
    fun getEyeDirection(): ConfiguredDoubleVector
}