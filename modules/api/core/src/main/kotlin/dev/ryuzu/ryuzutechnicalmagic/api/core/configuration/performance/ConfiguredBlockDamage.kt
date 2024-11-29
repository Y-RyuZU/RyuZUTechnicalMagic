package dev.ryuzu.ryuzutechnicalmagic.api.core.configuration.performance

data class ConfiguredBlockDamage(
    val amount: Double,
    val attribute: dev.ryuzu.ryuzutechnicalmagic.api.core.configuration.performance.Attribute,
    val delay: Int
)
