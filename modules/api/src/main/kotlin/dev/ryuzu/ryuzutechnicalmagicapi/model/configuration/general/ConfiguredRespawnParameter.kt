package dev.ryuzu.ryuzutechnicalmagicapi.model.configuration.general

import dev.ryuzu.ryuzutechnicalmagicapi.model.configuration.base.ConfiguredIntVector

data class ConfiguredRespawnParameter(
    val defaultRespawnPoint: ConfiguredIntVector,
    val respawnTime: Int,
)
