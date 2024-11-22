package dev.ryuzu.ryuzutechnicalmagiccore.model.configuration.game.team

import dev.ryuzu.ryuzutechnicalmagiccore.model.configuration.base.ConfiguredIntVector

data class ConfiguredTeam(
    val id: String,
    val name: String,
    val respawnPoint: ConfiguredIntVector,
    val color: ConfiguredIntVector
)
