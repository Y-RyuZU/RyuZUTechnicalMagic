package dev.ryuzu.ryuzutechnicalmagic.api.core.configuration.data.database

data class ConfiguredMongoConnectionInfo(
    val host: String,
    val port: Int,
    val database: String,
) {
    val uri: String = "mongodb://$host:$port/$database"
}
