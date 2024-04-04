package com.github.ryuzu.ryuzutechnicalmagiccore.core.util.wrapper.damage

import com.github.ryuzu.ryuzutechnicalmagiccore.core.event.data.skill.ISkillActivateEvent
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.player.IEntity
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.player.ILivingEntity
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.player.IPlayer

interface IDamageService {
    fun applyDamage(params: ISkillActivateEvent?, amount: Double, entities: Set<ILivingEntity>)
    fun applyDamage(params: ISkillActivateEvent?, amount: Double, vararg entities: ILivingEntity) = applyDamage(params, amount, entities.toSet())
}