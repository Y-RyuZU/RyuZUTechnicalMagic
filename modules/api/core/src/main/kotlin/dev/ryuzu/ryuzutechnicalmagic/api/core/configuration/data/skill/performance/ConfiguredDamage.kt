package dev.ryuzu.ryuzutechnicalmagic.api.core.configuration.data.skill.performance

data class ConfiguredDamage(
    val amount: Double,
    val ignoreResistance: Boolean,
    val element: Element,
    val delay: Int
)
