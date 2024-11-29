package dev.ryuzu.ryuzutechnicalmagic.api.core.configuration.performance

data class ConfiguredDamage(
    val amount: Double,
    val ignoreResistance: Boolean,
    val element: dev.ryuzu.ryuzutechnicalmagic.api.core.configuration.performance.Element,
    val delay: Int
)
