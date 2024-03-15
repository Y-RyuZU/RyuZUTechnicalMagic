package com.github.ryuzu.ryuzutechnicalmagiccore.core.model.game.team

import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.ConfiguredIntVector
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.ConfiguredLocation

data class TeamProperty(
    val name: String,
    val respawnPoint: ConfiguredLocation,
    val color: ConfiguredIntVector
)
