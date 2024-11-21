package dev.ryuzu.ryuzutechnicalmagiccore.model.configuration.game.stage

import dev.ryuzu.ryuzutechnicalmagiccore.model.configuration.game.anomaly.IConfiguredAnomalyParameter
import dev.ryuzu.ryuzutechnicalmagiccore.model.configuration.game.generator.ConfiguredGeneratorSet
import dev.ryuzu.ryuzutechnicalmagiccore.model.configuration.game.team.ConfiguredTeam

data class ConfiguredStage(
    val structure: String,
    val gameProperty: IConfiguredStageGameModeProperty,
    val display: ConfiguredStageDisplay,
    val generators: ConfiguredGeneratorSet,
    val teams: List<ConfiguredTeam>,
    val anomaly: Set<IConfiguredAnomalyParameter>,
    val itemTable: Map<Int, LinkedHashSet<String>>
)