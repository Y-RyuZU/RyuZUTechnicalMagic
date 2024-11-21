package dev.ryuzu.ryuzutechnicalmagiccore.model.configuration.performance

data class ConfiguredDamage(
    val amount: Double,
    val ignoreResistance: Boolean,
    val element: Element,
    val delay: Int
)
