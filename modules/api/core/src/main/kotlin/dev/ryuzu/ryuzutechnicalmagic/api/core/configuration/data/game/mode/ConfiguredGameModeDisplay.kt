package dev.ryuzu.ryuzutechnicalmagic.api.core.configuration.data.game.mode

data class ConfiguredGameModeDisplay(
    val name: String,
    val scoreboard: List<dev.ryuzu.ryuzutechnicalmagic.api.core.configuration.data.game.mode.ConfiguredScoreboard>,
    val description: List<String>,
)