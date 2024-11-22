package dev.ryuzu.ryuzutechnicalmagiccore.model.configuration.general

import dev.ryuzu.ryuzutechnicalmagiccore.model.configuration.base.ConfiguredIntVector

data class ConfiguredRespawnParameter(
    val defaultRespawnPoint: ConfiguredIntVector,
    val respawnTime: Int,
)
