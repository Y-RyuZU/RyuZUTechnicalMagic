package dev.ryuzu.ryuzutechnicalmagicapi.model.configuration.performance

data class ConfiguredBlockDamage(
    val amount: Double,
    val attribute: Attribute,
    val delay: Int
)
