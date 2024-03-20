package com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.game.stage

data class ConfiguredStage(
    val id: String,
    val gameProperty: IConfiguredStageGameModeProperty,
    val display: ConfiguredStageDisplay,
    val generators: ConfiguredGeneratorSet,
    val team: Set<ConfiguredTeam>,
    val anomaly: List<IConfiguredAnomalyParameter>
)