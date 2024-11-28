package dev.ryuzu.ryuzutechnicalmagic.core.impl.util.wrapper.scoreboard

import dev.ryuzu.ryuzutechnicalmagic.api.minecraft.adapter.scoreboard.IScoreboardService
import org.koin.core.annotation.Single
import org.koin.core.component.KoinComponent
import org.koin.core.component.get

@Single
class ScoreboardFactory : KoinComponent {
    fun createScoreboardService(): IScoreboardService = get()
}