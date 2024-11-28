package dev.ryuzu.ryuzutechnicalmagic.api.core.model.configuration.general

import dev.ryuzu.ryuzutechnicalmagic.api.core.model.configuration.base.ConfiguredIntVector

data class ConfiguredRespawnParameter(
    val defaultRespawnPoint: ConfiguredIntVector,
    val respawnTime: Int,
)
