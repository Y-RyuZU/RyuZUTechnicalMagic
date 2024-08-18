package com.github.ryuzu.ryuzutechnicalmagiccore.core.model.entity.effect

import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.entity.LivingEntity
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class StatusEffectContainer(private val entity: LivingEntity) : IStatusEffectContainer, KoinComponent {
    private val statusEffectStates = mutableListOf<StatusEffectState>();
    private val statusEffectService: IStatusEffectService by inject()

    override fun apply(statusEffectState: StatusEffectState) {
        statusEffectStates.add(statusEffectState)
        statusEffectService.apply(entity, statusEffectState)
    }

    override fun remove(statusEffectId: StatusEffectId) {
        statusEffectStates.removeIf { it.id == statusEffectId }
        get(statusEffectId).forEach { statusEffectService.remove(entity, it) }
    }

    override fun remove(state: StatusEffectState) {
        statusEffectStates.remove(state)
        statusEffectService.remove(entity, state)
    }

    override fun get(statusEffectId: StatusEffectId): List<StatusEffectState> = statusEffectStates.filter { it.id == statusEffectId }

    override fun getAll(): List<StatusEffectState> = statusEffectStates

    override fun clear() {
        statusEffectStates.forEach{ remove(it) }
    }

}