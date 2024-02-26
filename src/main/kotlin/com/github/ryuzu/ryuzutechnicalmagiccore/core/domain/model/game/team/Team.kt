package com.github.ryuzu.ryuzutechnicalmagiccore.core.domain.model.game.team

import com.github.ryuzu.ryuzutechnicalmagiccore.core.domain.model.configuration.ConfiguredIntVector
import com.github.ryuzu.ryuzutechnicalmagiccore.core.domain.model.configuration.ConfiguredLocation

data class Team(
    val name: String,
    val respawnPoint: ConfiguredLocation,
    val color: ConfiguredIntVector
)
