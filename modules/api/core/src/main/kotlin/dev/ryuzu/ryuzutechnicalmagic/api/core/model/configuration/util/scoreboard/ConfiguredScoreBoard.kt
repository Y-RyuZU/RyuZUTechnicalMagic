package dev.ryuzu.ryuzutechnicalmagic.api.core.model.configuration.util.scoreboard

data class ConfiguredScoreBoard(
    val title: String = "",
    val lines: List<String> = emptyList()
)