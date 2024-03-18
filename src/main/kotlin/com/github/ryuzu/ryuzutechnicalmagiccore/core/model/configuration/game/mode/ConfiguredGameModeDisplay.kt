package com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.game.mode

import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.game.stage.ConfiguredScoreboard

data class ConfiguredGameModeDisplay(
    val name: String,
    val bossBar: List<ConfiguredScoreboard>,
)