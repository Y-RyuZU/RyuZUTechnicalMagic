package dev.ryuzu.ryuzutechnicalmagic.api.game.data.team

import dev.ryuzu.ryuzutechnicalmagic.api.core.data.base.SerIntVector

data class SerTeam(
    val id: String,
    val name: String,
    val respawnPoint: SerIntVector,
    val color: SerIntVector
)
