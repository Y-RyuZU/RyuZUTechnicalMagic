package dev.ryuzu.ryuzutechnicalmagic.api.core.model.configuration.performance

data class ConfiguredBlockDamage(
    val amount: Double,
    val attribute: Attribute,
    val delay: Int
)
