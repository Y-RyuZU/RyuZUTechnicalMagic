package com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.game.team

import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.base.ConfiguredIntVector

data class ConfiguredTeam(
    val id: String,
    val name: String,
    val respawnPoint: ConfiguredIntVector,
    val color: ConfiguredIntVector
)
