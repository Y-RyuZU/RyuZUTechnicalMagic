package dev.ryuzu.ryuzutechnicalmagic.api.core.model.entity.effect

interface IStatusEffect {
    val onEffectStart: Unit
    val onEffectTick: Unit
    val onEffectEnd: Unit
}