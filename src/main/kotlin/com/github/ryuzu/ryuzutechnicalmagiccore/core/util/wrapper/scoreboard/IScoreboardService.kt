package com.github.ryuzu.ryuzutechnicalmagiccore.core.util.wrapper.scoreboard

import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.game.mode.ConfiguredScoreboard
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.entity.IPlayer
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.scheduler.UpdatePeriod
import org.koin.core.component.KoinComponent

interface IScoreboardService : KoinComponent {
    fun createScoreboard(scoreboard: List<ConfiguredScoreboard>, placeholders: Map<String, () -> String>, period: UpdatePeriod = UpdatePeriod.SECOND): IScoreboardService
    fun addPlayers(players: Set<IPlayer>)
    fun addPlayers(vararg players: IPlayer) = addPlayers(players.toSet())
    fun removePlayers(players: Set<IPlayer>)
    fun removePlayers(vararg players: IPlayer) = removePlayers(players.toSet())
    fun destroy()
}