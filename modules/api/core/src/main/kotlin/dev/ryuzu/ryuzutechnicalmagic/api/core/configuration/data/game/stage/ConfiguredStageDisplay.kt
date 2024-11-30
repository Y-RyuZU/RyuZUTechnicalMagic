package dev.ryuzu.ryuzutechnicalmagic.api.core.configuration.data.game.stage

import dev.ryuzu.ryuzutechnicalmagic.api.core.configuration.data.bossbar.ConfiguredBossBar

data class ConfiguredStageDisplay(
    val name: String,
    val bossBar: ConfiguredBossBar,
)