package dev.ryuzu.ryuzutechnicalmagic.api.core.data.general

import dev.ryuzu.ryuzutechnicalmagic.api.core.data.base.SerIntVector

data class SerRespawnParameter(
    val defaultRespawnPoint: SerIntVector,
    val respawnTime: Int,
)
