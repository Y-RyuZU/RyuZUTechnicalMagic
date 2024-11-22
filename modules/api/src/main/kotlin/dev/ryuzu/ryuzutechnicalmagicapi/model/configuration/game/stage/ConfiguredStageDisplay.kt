package dev.ryuzu.ryuzutechnicalmagicapi.model.configuration.game.stage

import dev.ryuzu.ryuzutechnicalmagicapi.model.configuration.util.bossbar.ConfiguredBossBar

data class ConfiguredStageDisplay(
    val name: String,
    val bossBar: ConfiguredBossBar,
)