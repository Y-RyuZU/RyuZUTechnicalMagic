package dev.ryuzu.ryuzutechnicalmagiccore.model.entity.effect

interface IStatusEffect {
    val onEffectStart: Unit
    val onEffectTick: Unit
    val onEffectEnd: Unit
}