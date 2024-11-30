package dev.ryuzu.ryuzutechnicalmagic.api.core.configuration.data.database

data class ConfiguredRedisConnectionInfo(
    val host: String,
    val port: Int,
    val password: String,
)
