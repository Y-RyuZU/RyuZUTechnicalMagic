package com.github.ryuzu.ryuzutechnicalmagiccore.core.model.game.stage

import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.game.team.ConfiguredTeam
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.game.anomaly.AnomalyType
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.game.anomaly.IAnomalyProperty
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.game.generator.GeneratorSets
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.game.mode.GameMode
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.game.mode.property.GameModeProperty

data class StageProperty(
    val structure: String,
    val gameMode: GameMode,
    val display: StageDisplaySet,
    val generatorSet: GeneratorSets,
    val teams: Map<String, ConfiguredTeam>,
    val events: Map<AnomalyType, IAnomalyProperty>,
    val property: GameModeProperty,
)
