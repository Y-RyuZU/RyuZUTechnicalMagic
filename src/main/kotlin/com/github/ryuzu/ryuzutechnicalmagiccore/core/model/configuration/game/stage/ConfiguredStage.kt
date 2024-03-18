package com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.game.stage

import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.game.mode.GameMode
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.game.mode.ConfiguredGameMode

data class ConfiguredStage(
    val id: String,
    val gameMode: GameMode,
    val gameProperty: ConfiguredGameMode

)