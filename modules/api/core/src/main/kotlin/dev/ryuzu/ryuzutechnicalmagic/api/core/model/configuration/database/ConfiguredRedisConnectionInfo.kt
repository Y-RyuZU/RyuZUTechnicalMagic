package dev.ryuzu.ryuzutechnicalmagic.api.core.model.configuration.database

data class ConfiguredRedisConnectionInfo(
    val host: String,
    val port: Int,
    val password: String,
)
