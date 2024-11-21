package dev.ryuzu.ryuzutechnicalmagiccore.model.configuration.database

data class ConfiguredRedisConnectionInfo(
    val host: String,
    val port: Int,
    val password: String,
)
