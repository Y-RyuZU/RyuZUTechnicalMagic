package com.github.ryuzu.ryuzutechnicalmagiccore.minecraft.adapter

import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.entity.ILivingEntity
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.entity.effect.StatusEffectId

interface IPotionEffectAdapter {
    fun apply(entity: ILivingEntity, statusEffectId: StatusEffectId, duration: Int, amplifier: Int)

    fun remove(entity: ILivingEntity, statusEffectId: StatusEffectId)
}