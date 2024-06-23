package com.github.ryuzu.ryuzutechnicalmagiccore.core.model.entity.effect

interface IStatusEffect {
    val onEffectStart: Unit
    val onEffectTick: Unit
    val onEffectEnd: Unit
}