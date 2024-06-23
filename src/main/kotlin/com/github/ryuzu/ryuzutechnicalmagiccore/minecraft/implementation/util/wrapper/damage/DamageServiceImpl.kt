package com.github.ryuzu.ryuzutechnicalmagiccore.minecraft.implementation.util.wrapper.damage

import com.github.ryuzu.ryuzutechnicalmagiccore.core.event.data.skill.IEntitySkillCastEvent
import com.github.ryuzu.ryuzutechnicalmagiccore.core.event.data.skill.ISkillActivateEvent
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.entity.ILivingEntity
import com.github.ryuzu.ryuzutechnicalmagiccore.core.util.wrapper.damage.IDamageService
import com.github.ryuzu.ryuzutechnicalmagiccore.minecraft.util.EntityUtility.Companion.toEntity
import com.github.ryuzu.ryuzutechnicalmagiccore.minecraft.util.EntityUtility.Companion.toLivingEntity
import org.bukkit.damage.DamageSource
import org.bukkit.damage.DamageType
import org.koin.core.annotation.Single
import org.koin.core.component.KoinComponent

@Single([IDamageService::class])
class DamageServiceImpl : IDamageService, KoinComponent {
    override fun applyDamage(params: ISkillActivateEvent, amount: Double, entities: Set<ILivingEntity>) {
        val causer = (params as? IEntitySkillCastEvent)?.entity?.toEntity()

        if (causer == null)
            entities.forEach { it.toLivingEntity().damage(amount) }
        else {
            entities.forEach {
                val damageSource = RTMDamageSource(
                    DamageSource.builder(DamageType.GENERIC).withCausingEntity(causer).withDirectEntity(causer).build(),
                    params.skillSetId,
                    params.skillId
                )

                it.toLivingEntity().damage(amount, damageSource)
            }
        }
    }
}