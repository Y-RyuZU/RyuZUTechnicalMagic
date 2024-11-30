package dev.ryuzu.ryuzutechnicalmagic.api.core.configuration.data.scoreboard

data class ConfiguredScoreBoard(
    val title: String = "",
    val lines: List<String> = emptyList()
)