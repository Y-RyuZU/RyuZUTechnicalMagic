package dev.ryuzu.ryuzutechnicalmagic.api.game.data.stage

import dev.ryuzu.ryuzutechnicalmagic.api.game.data.anomaly.ISerAnomalyParameter
import dev.ryuzu.ryuzutechnicalmagic.api.game.data.generator.ConfiguredGeneratorSet
import dev.ryuzu.ryuzutechnicalmagic.api.game.data.team.SerTeam

data class ConfiguredStage(
    val structure: String,
    val gameProperty: ISerStageGameModeProperty,
    val display: SerStageDisplay,
    val generators: ConfiguredGeneratorSet,
    val teams: List<SerTeam>,
    val anomaly: Set<ISerAnomalyParameter>,
    val itemTable: Map<Int, LinkedHashSet<String>>
)