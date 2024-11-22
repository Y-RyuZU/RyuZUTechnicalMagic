package dev.ryuzu.ryuzutechnicalmagicapi.util.wrapper.scoreboard

import dev.ryuzu.ryuzutechnicalmagicapi.model.configuration.game.mode.ConfiguredScoreboard
import dev.ryuzu.ryuzutechnicalmagicapi.model.entity.IPlayer
import dev.ryuzu.ryuzutechnicalmagicapi.model.scheduler.UpdatePeriod

interface IScoreboardService {
    fun createScoreboard(scoreboard: List<ConfiguredScoreboard>, placeholders: Map<String, () -> String>, period: UpdatePeriod = UpdatePeriod.SECOND): IScoreboardService
    fun addPlayers(players: Set<IPlayer>)
    fun addPlayers(vararg players: IPlayer) = addPlayers(players.toSet())
    fun removePlayers(players: Set<IPlayer>)
    fun removePlayers(vararg players: IPlayer) = removePlayers(players.toSet())
    fun destroy()
}