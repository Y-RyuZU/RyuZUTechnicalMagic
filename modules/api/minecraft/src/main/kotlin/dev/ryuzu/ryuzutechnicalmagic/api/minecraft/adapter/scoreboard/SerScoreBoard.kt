package dev.ryuzu.ryuzutechnicalmagic.api.minecraft.adapter.scoreboard

data class SerScoreBoard(
    val title: String = "",
    val lines: List<String> = emptyList()
)