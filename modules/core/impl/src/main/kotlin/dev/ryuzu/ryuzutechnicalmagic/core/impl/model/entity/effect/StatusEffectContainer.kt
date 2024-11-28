package dev.ryuzu.ryuzutechnicalmagic.core.impl.model.entity.effect

import dev.ryuzu.ryuzutechnicalmagic.api.core.model.entity.effect.IStatusEffectContainer
import dev.ryuzu.ryuzutechnicalmagic.api.core.model.entity.effect.StatusEffectId
import dev.ryuzu.ryuzutechnicalmagic.api.core.model.entity.effect.StatusEffectState

class StatusEffectContainer : IStatusEffectContainer {
    override fun apply(statusEffectId: StatusEffectId, duration: Long, level: Int) {
        TODO("Not yet implemented")
    }

    override fun remove(statusEffectId: StatusEffectId) {
        TODO("Not yet implemented")
    }

    override fun remove(state: StatusEffectState) {
        TODO("Not yet implemented")
    }

    override fun get(statusEffectId: StatusEffectId): StatusEffectState? {
        TODO("Not yet implemented")
    }

    override fun getAll(): List<StatusEffectState> {
        TODO("Not yet implemented")
    }

    override fun clear() {
        TODO("Not yet implemented")
    }

}