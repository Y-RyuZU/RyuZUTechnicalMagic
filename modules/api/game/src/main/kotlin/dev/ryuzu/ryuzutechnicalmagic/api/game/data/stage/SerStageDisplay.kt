package dev.ryuzu.ryuzutechnicalmagic.api.game.data.stage

import dev.ryuzu.ryuzutechnicalmagic.api.core.data.bossbar.SerBossBar

data class SerStageDisplay(
    val name: String,
    val bossBar: SerBossBar,
)