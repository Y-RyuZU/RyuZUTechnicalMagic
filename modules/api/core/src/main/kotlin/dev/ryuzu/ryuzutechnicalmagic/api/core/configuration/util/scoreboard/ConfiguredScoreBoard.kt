package dev.ryuzu.ryuzutechnicalmagic.api.core.configuration.util.scoreboard

data class ConfiguredScoreBoard(
    val title: String = "",
    val lines: List<String> = emptyList()
)