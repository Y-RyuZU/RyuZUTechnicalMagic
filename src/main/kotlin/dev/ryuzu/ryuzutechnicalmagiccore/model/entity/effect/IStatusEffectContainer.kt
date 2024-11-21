package dev.ryuzu.ryuzutechnicalmagiccore.model.entity.effect

interface IStatusEffectContainer {
    fun apply(statusEffectId: dev.ryuzu.ryuzutechnicalmagiccore.model.entity.effect.StatusEffectId, duration: Long, level: Int)
    fun remove(statusEffectId: dev.ryuzu.ryuzutechnicalmagiccore.model.entity.effect.StatusEffectId)
    fun remove(state: dev.ryuzu.ryuzutechnicalmagiccore.model.entity.effect.StatusEffectState)
    fun get(statusEffectId: dev.ryuzu.ryuzutechnicalmagiccore.model.entity.effect.StatusEffectId): dev.ryuzu.ryuzutechnicalmagiccore.model.entity.effect.StatusEffectState?
    fun getAll(): List<dev.ryuzu.ryuzutechnicalmagiccore.model.entity.effect.StatusEffectState>
    fun clear()
}