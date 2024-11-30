package dev.ryuzu.ryuzutechnicalmagic.minecraft.paper.implementation.util.wrapper.scoreboard

import dev.ryuzu.ryuzutechnicalmagic.api.minecraft.adapter.scoreboard.IScoreboardFactory
import dev.ryuzu.ryuzutechnicalmagic.api.minecraft.adapter.scoreboard.IScoreboardObject
import org.koin.core.annotation.Single
import org.koin.core.component.KoinComponent
import org.koin.core.component.get

@Single([IScoreboardFactory::class])
class ScoreboardFactoryImpl : IScoreboardFactory, KoinComponent {
    override fun createScoreboard(): IScoreboardObject = get()
}