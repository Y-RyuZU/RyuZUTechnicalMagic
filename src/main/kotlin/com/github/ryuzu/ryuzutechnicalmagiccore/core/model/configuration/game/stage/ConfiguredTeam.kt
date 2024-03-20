package com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.game.stage

import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.base.ConfiguredIntVector

data class ConfiguredTeam(
    val name: String,
    val respawnPoint: ConfiguredIntVector,
    val color: ConfiguredIntVector
)
