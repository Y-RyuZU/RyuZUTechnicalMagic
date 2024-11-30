package dev.ryuzu.ryuzutechnicalmagic.api.core.model.entity.statuseffect

interface IStatusEffect {
    val onEffectStart: Unit
    val onEffectTick: Unit
    val onEffectEnd: Unit
}