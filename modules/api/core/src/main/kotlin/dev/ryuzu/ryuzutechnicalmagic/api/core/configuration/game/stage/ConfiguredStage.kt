package dev.ryuzu.ryuzutechnicalmagic.api.core.configuration.game.stage

import dev.ryuzu.ryuzutechnicalmagic.api.core.model.configuration.game.anomaly.IConfiguredAnomalyParameter
import dev.ryuzu.ryuzutechnicalmagic.api.core.model.configuration.game.generator.ConfiguredGeneratorSet
import dev.ryuzu.ryuzutechnicalmagic.api.core.model.configuration.game.team.ConfiguredTeam

data class ConfiguredStage(
    val structure: String,
    val gameProperty: dev.ryuzu.ryuzutechnicalmagic.api.core.configuration.game.stage.IConfiguredStageGameModeProperty,
    val display: ConfiguredStageDisplay,
    val generators: ConfiguredGeneratorSet,
    val teams: List<ConfiguredTeam>,
    val anomaly: Set<IConfiguredAnomalyParameter>,
    val itemTable: Map<Int, LinkedHashSet<String>>
)