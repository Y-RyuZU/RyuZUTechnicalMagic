package service.damage

import dev.ryuzu.ryuzutechnicalmagic.api.core.model.entity.ILivingEntity
import event.data.ISkillActivateEvent

interface IDamageService {
    fun applyDamage(params: ISkillActivateEvent, amount: Double, entities: Set<ILivingEntity>)
    fun applyDamage(params: ISkillActivateEvent, amount: Double, vararg entities: ILivingEntity) = applyDamage(params, amount, entities.toSet())
}