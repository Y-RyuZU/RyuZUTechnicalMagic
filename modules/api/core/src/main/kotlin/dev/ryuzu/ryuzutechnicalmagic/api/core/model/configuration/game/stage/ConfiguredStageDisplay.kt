package dev.ryuzu.ryuzutechnicalmagic.api.core.model.configuration.game.stage

import dev.ryuzu.ryuzutechnicalmagic.api.core.model.configuration.util.bossbar.ConfiguredBossBar

data class ConfiguredStageDisplay(
    val name: String,
    val bossBar: ConfiguredBossBar,
)