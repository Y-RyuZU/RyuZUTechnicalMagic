package com.github.ryuzu.ryuzutechnicalmagiccore.core.model.entity.effect

interface IStatusEffect {
    fun onEffectStart(level: Int): Unit
    fun onEffectTick(level: Int): Unit
    fun onEffectEnd(level: Int): Unit
}