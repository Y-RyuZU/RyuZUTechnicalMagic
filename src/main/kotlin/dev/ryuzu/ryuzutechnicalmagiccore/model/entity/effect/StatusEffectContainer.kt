package dev.ryuzu.ryuzutechnicalmagiccore.model.entity.effect

class StatusEffectContainer : dev.ryuzu.ryuzutechnicalmagiccore.model.entity.effect.IStatusEffectContainer {
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