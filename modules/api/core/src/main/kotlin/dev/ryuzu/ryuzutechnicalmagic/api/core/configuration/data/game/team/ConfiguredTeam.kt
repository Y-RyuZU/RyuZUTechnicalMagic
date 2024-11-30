package dev.ryuzu.ryuzutechnicalmagic.api.core.configuration.data.game.team

import dev.ryuzu.ryuzutechnicalmagic.api.core.configuration.data.base.ConfiguredIntVector

data class ConfiguredTeam(
    val id: String,
    val name: String,
    val respawnPoint: ConfiguredIntVector,
    val color: ConfiguredIntVector
)
