package dev.ryuzu.ryuzutechnicalmagic.api.game.data.mode

data class ConfiguredGameModeDisplay(
    val name: String,
    val scoreboard: List<dev.ryuzu.ryuzutechnicalmagic.api.game.data.mode.ConfiguredScoreboard>,
    val description: List<String>,
)