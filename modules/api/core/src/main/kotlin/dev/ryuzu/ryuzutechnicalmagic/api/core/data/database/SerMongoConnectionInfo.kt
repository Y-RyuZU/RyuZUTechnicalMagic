package dev.ryuzu.ryuzutechnicalmagic.api.core.data.database

data class SerMongoConnectionInfo(
    val host: String,
    val port: Int,
    val database: String,
) {
    val uri: String = "mongodb://$host:$port/$database"
}
