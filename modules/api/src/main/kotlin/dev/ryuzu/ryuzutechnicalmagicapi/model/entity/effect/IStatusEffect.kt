package dev.ryuzu.ryuzutechnicalmagicapi.model.entity.effect

interface IStatusEffect {
    val onEffectStart: Unit
    val onEffectTick: Unit
    val onEffectEnd: Unit
}