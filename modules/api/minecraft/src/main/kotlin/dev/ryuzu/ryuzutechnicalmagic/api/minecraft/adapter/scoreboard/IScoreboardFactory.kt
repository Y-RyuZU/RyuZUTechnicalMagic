package dev.ryuzu.ryuzutechnicalmagic.api.minecraft.adapter.scoreboard

interface IScoreboardFactory {
    fun createScoreboard(): IScoreboardObject
}