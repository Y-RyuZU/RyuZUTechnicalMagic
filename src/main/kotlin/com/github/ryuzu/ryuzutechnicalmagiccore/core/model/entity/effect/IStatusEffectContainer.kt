package com.github.ryuzu.ryuzutechnicalmagiccore.core.model.entity.effect

interface IStatusEffectContainer {
    fun apply(statusEffectId: StatusEffectId, duration: Long, level: Int) = apply(StatusEffectState(statusEffectId, duration, level))
    fun apply(statusEffectState: StatusEffectState)
    fun remove(statusEffectId: StatusEffectId)
    fun remove(state: StatusEffectState)
    fun get(statusEffectId: StatusEffectId): List<StatusEffectState>?
    fun getAll(): List<StatusEffectState>
    fun clear()
}