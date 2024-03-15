package com.github.ryuzu.ryuzutechnicalmagiccore.core.model.game.stage

import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.game.team.TeamProperty
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.game.stage.anomaly.AnomalyType
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.game.stage.anomaly.property.IAnomalyProperty
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.game.generator.GeneratorSets
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.game.mode.GameMode
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.game.mode.property.GameModeProperty

data class StageProperty(
    val structure: String,
    val gameMode: GameMode,
    val display: StageDisplaySet,
    val generatorSet: GeneratorSets,
    val teams: HashMap<String, TeamProperty>,
    val events: HashMap<AnomalyType, IAnomalyProperty>,
    val property: GameModeProperty,
)
