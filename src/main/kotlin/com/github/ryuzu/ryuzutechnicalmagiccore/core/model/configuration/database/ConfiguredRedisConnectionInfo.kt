package com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.database

data class ConfiguredRedisConnectionInfo(
    val host: String,
    val port: Int,
    val password: String,
)
