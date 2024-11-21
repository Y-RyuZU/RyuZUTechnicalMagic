package dev.ryuzu.ryuzutechnicalmagiccore.util.wrapper.scoreboard

import dev.ryuzu.ryuzutechnicalmagiccore.model.configuration.game.mode.ConfiguredScoreboard
import dev.ryuzu.ryuzutechnicalmagiccore.model.entity.IPlayer
import dev.ryuzu.ryuzutechnicalmagiccore.model.scheduler.UpdatePeriod
import org.koin.core.component.KoinComponent

interface IScoreboardService : KoinComponent {
    fun createScoreboard(scoreboard: List<ConfiguredScoreboard>, placeholders: Map<String, () -> String>, period: UpdatePeriod = UpdatePeriod.SECOND): IScoreboardService
    fun addPlayers(players: Set<IPlayer>)
    fun addPlayers(vararg players: IPlayer) = addPlayers(players.toSet())
    fun removePlayers(players: Set<IPlayer>)
    fun removePlayers(vararg players: IPlayer) = removePlayers(players.toSet())
    fun destroy()
}