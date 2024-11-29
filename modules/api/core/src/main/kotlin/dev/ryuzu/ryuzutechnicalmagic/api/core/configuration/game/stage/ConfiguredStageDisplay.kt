package dev.ryuzu.ryuzutechnicalmagic.api.core.configuration.game.stage

import dev.ryuzu.ryuzutechnicalmagic.api.core.configuration.util.bossbar.ConfiguredBossBar

data class ConfiguredStageDisplay(
    val name: String,
    val bossBar: ConfiguredBossBar,
)