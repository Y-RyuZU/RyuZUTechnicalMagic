package com.github.ryuzu.ryuzutechnicalmagiccore.core.model.entity.effect

import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.entity.LivingEntity

interface IStatusEffectService {
    fun apply(entity: LivingEntity, statusEffectState: StatusEffectState)

    fun remove(entity: LivingEntity, statusEffectState: StatusEffectState)
}