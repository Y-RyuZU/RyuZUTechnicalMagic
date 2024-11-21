package dev.ryuzu.ryuzutechnicalmagiccore.model.configuration.game.stage

import dev.ryuzu.ryuzutechnicalmagiccore.model.configuration.util.bossbar.ConfiguredBossBar

data class ConfiguredStageDisplay(
    val name: String,
    val bossBar: ConfiguredBossBar,
)