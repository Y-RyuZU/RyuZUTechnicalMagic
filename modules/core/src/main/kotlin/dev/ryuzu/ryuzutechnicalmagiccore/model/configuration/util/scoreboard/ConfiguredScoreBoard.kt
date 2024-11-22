package dev.ryuzu.ryuzutechnicalmagiccore.model.configuration.util.scoreboard

data class ConfiguredScoreBoard(
    val title: String = "",
    val lines: List<String> = emptyList()
)