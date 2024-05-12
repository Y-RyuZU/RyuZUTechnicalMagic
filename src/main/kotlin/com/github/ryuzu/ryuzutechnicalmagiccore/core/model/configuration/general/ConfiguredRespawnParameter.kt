package com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.general

import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.base.ConfiguredIntVector

data class ConfiguredRespawnParameter(
    val defaultRespawnPoint: ConfiguredIntVector,
    val respawnTime: Int,
)
