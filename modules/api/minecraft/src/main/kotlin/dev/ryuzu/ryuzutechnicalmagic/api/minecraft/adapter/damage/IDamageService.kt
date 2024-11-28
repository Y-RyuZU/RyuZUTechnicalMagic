package dev.ryuzu.ryuzutechnicalmagic.api.minecraft.adapter.damage

import dev.ryuzu.ryuzutechnicalmagic.api.core.event.data.skill.ISkillActivateEvent
import dev.ryuzu.ryuzutechnicalmagic.api.core.model.entity.ILivingEntity

interface IDamageService {
    fun applyDamage(params: ISkillActivateEvent, amount: Double, entities: Set<ILivingEntity>)
    fun applyDamage(params: ISkillActivateEvent, amount: Double, vararg entities: ILivingEntity) = applyDamage(params, amount, entities.toSet())
}