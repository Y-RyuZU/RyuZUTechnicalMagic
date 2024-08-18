package com.github.ryuzu.ryuzutechnicalmagiccore.core.model.entity.effect

import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.entity.LivingEntity
import com.github.ryuzu.ryuzutechnicalmagiccore.minecraft.adapter.IPotionEffectAdapter
import org.koin.core.annotation.Single
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

@Single([StatusEffectServiceImpl::class], true)
class StatusEffectServiceImpl : IStatusEffectService, KoinComponent {
    val potionEffectAdapter: IPotionEffectAdapter by inject()
    val statusEffectClasses: Map<String, IStatusEffect> =
        getKoin().getAll<IStatusEffect>().associateBy { it.javaClass.simpleName }

    override fun apply(entity: LivingEntity, statusEffectState: StatusEffectState) {
        if (statusEffectState.id.vanilla) potionEffectAdapter.apply(
            entity,
            statusEffectState.id,
            statusEffectState.duration,
            statusEffectState.level
        )
        else statusEffectClasses[statusEffectState.id.toString()]?.onEffectStart(statusEffectState.level)
    }

    override fun remove(entity: LivingEntity, statusEffectState: StatusEffectState) {
        if (statusEffectState.id.vanilla) potionEffectAdapter.remove(entity, statusEffectState.id)
        else statusEffectClasses[statusEffectState.id.toString()]?.onEffectEnd(statusEffectState.level)
    }
}