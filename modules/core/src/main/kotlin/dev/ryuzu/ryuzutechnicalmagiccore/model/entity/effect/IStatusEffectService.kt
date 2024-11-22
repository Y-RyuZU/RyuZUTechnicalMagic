package dev.ryuzu.ryuzutechnicalmagiccore.model.entity.effect

interface IStatusEffectService {
    fun apply(statusEffectId: StatusEffectId, duration: Long, level: Int)
    fun remove(statusEffectId: StatusEffectId)
    fun remove(state: StatusEffectState)
    fun get(statusEffectId: StatusEffectId): StatusEffectState?
    fun getAll(): List<StatusEffectState>
    fun clear()
}