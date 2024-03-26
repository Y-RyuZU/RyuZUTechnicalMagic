package com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.database

data class ConfiguredMongoConnectionInfo(
    val host: String,
    val port: Int,
    val database: String,
) {
    val uri: String = "mongodb://$host:$port/$database"
}
