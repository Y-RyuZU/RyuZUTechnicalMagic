package dev.ryuzu.ryuzutechnicalmagic.api.core.configuration.general

import dev.ryuzu.ryuzutechnicalmagic.api.core.configuration.base.ConfiguredIntVector

data class ConfiguredRespawnParameter(
    val defaultRespawnPoint: dev.ryuzu.ryuzutechnicalmagic.api.core.configuration.base.ConfiguredIntVector,
    val respawnTime: Int,
)
