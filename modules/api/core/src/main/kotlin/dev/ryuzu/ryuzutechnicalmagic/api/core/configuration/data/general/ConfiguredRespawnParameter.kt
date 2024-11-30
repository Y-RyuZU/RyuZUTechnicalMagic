package dev.ryuzu.ryuzutechnicalmagic.api.core.configuration.data.general

import dev.ryuzu.ryuzutechnicalmagic.api.core.configuration.data.base.ConfiguredIntVector

data class ConfiguredRespawnParameter(
    val defaultRespawnPoint: ConfiguredIntVector,
    val respawnTime: Int,
)
