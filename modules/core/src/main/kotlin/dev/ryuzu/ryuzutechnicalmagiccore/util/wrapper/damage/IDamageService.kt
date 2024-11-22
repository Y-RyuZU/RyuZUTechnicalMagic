package dev.ryuzu.ryuzutechnicalmagiccore.util.wrapper.damage

import dev.ryuzu.ryuzutechnicalmagiccore.event.data.skill.ISkillActivateEvent
import dev.ryuzu.ryuzutechnicalmagiccore.model.entity.ILivingEntity

interface IDamageService {
    fun applyDamage(params: ISkillActivateEvent, amount: Double, entities: Set<ILivingEntity>)
    fun applyDamage(params: ISkillActivateEvent, amount: Double, vararg entities: ILivingEntity) = applyDamage(params, amount, entities.toSet())
}