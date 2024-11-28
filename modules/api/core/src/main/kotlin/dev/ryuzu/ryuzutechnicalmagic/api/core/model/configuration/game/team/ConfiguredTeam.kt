package dev.ryuzu.ryuzutechnicalmagic.api.core.model.configuration.game.team

import dev.ryuzu.ryuzutechnicalmagic.api.core.model.configuration.base.ConfiguredIntVector

data class ConfiguredTeam(
    val id: String,
    val name: String,
    val respawnPoint: ConfiguredIntVector,
    val color: ConfiguredIntVector
)
