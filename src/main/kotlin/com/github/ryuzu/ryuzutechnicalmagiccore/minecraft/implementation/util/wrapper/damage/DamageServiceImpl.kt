package com.github.ryuzu.ryuzutechnicalmagiccore.minecraft.implementation.util.wrapper.damage

import com.github.ryuzu.ryuzutechnicalmagiccore.core.event.data.skill.IEntitySkillCastEvent
import com.github.ryuzu.ryuzutechnicalmagiccore.core.event.data.skill.ISkillActivateEvent
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.player.IEntity
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.player.ILivingEntity
import com.github.ryuzu.ryuzutechnicalmagiccore.core.util.wrapper.damage.IDamageService
import com.github.ryuzu.ryuzutechnicalmagiccore.minecraft.util.EntityUtility.Companion.toEntity
import com.github.ryuzu.ryuzutechnicalmagiccore.minecraft.util.EntityUtility.Companion.toLivingEntity
import org.koin.core.annotation.Single
import org.koin.core.component.KoinComponent

@Single([IDamageService::class])
class DamageServiceImpl : IDamageService, KoinComponent {
    override fun applyDamage(params: ISkillActivateEvent?, amount: Double, entities: Set<ILivingEntity>) {
        entities.forEach {
            it.toLivingEntity().damage(amount, (params as? IEntitySkillCastEvent)?.entity?.toEntity())
        }
    }
}