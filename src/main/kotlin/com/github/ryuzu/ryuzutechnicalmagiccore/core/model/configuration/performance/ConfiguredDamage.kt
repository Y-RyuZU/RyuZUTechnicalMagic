package com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.performance

data class ConfiguredDamage(
    val amount: Double,
    val ignoreResistance: Boolean,
    val element: Element,
    val delay: Int
)
