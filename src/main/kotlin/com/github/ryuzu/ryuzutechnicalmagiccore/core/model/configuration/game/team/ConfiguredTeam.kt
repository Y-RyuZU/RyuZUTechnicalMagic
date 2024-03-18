package com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.game.team

import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.base.ConfiguredIntVector
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.base.ConfiguredLocation

data class ConfiguredTeam(
    val name: String,
    val respawnPoint: ConfiguredLocation,
    val color: ConfiguredIntVector
)
