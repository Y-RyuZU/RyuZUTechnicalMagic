package dev.ryuzu.ryuzutechnicalmagiccore.util.wrapper.scoreboard

import org.koin.core.annotation.Single
import org.koin.core.component.KoinComponent
import org.koin.core.component.get

@Single
class ScoreboardFactory : KoinComponent {
    fun createScoreboardService(): IScoreboardService = get()
}