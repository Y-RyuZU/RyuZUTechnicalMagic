package com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.game.stage

import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.game.anomaly.IConfiguredAnomalyParameter
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.game.generator.ConfiguredGeneratorSet
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.game.team.ConfiguredTeam

data class ConfiguredStage(
    val structure: String,
    val gameProperty: IConfiguredStageGameModeProperty,
    val display: ConfiguredStageDisplay,
    val generators: ConfiguredGeneratorSet,
    val teams: List<ConfiguredTeam>,
    val anomaly: Set<IConfiguredAnomalyParameter>,
    val itemTable: Map<Int, LinkedHashSet<String>>
)