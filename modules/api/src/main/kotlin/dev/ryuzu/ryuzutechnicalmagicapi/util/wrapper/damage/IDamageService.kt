package dev.ryuzu.ryuzutechnicalmagicapi.util.wrapper.damage

import dev.ryuzu.ryuzutechnicalmagicapi.event.data.skill.ISkillActivateEvent
import dev.ryuzu.ryuzutechnicalmagicapi.model.entity.ILivingEntity

interface IDamageService {
    fun applyDamage(params: ISkillActivateEvent, amount: Double, entities: Set<ILivingEntity>)
    fun applyDamage(params: ISkillActivateEvent, amount: Double, vararg entities: ILivingEntity) = applyDamage(params, amount, entities.toSet())
}