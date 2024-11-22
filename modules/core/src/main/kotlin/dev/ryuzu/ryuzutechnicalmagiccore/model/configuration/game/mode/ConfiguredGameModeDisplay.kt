package dev.ryuzu.ryuzutechnicalmagiccore.model.configuration.game.mode

data class ConfiguredGameModeDisplay(
    val name: String,
    val scoreboard: List<ConfiguredScoreboard>,
    val description: List<String>,
)