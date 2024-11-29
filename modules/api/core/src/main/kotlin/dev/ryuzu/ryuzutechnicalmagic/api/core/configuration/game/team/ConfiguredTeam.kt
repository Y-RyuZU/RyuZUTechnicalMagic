package dev.ryuzu.ryuzutechnicalmagic.api.core.configuration.game.team

import dev.ryuzu.ryuzutechnicalmagic.api.core.configuration.base.ConfiguredIntVector

data class ConfiguredTeam(
    val id: String,
    val name: String,
    val respawnPoint: dev.ryuzu.ryuzutechnicalmagic.api.core.configuration.base.ConfiguredIntVector,
    val color: dev.ryuzu.ryuzutechnicalmagic.api.core.configuration.base.ConfiguredIntVector
)
