package dev.ryuzu.ryuzutechnicalmagic.api.minecraft.adapter.scoreboard

import dev.ryuzu.ryuzutechnicalmagic.api.core.model.configuration.game.mode.ConfiguredScoreboard
import dev.ryuzu.ryuzutechnicalmagic.api.core.model.scheduler.UpdatePeriod

interface IScoreboardService {
    fun createScoreboard(scoreboard: List<ConfiguredScoreboard>, placeholders: Map<String, () -> String>, period: UpdatePeriod = UpdatePeriod.SECOND): IScoreboardService
    fun addPlayers(players: Set<dev.ryuzu.ryuzutechnicalmagic.api.core.model.entity.IPlayer>)
    fun addPlayers(vararg players: dev.ryuzu.ryuzutechnicalmagic.api.core.model.entity.IPlayer) = addPlayers(players.toSet())
    fun removePlayers(players: Set<dev.ryuzu.ryuzutechnicalmagic.api.core.model.entity.IPlayer>)
    fun removePlayers(vararg players: dev.ryuzu.ryuzutechnicalmagic.api.core.model.entity.IPlayer) = removePlayers(players.toSet())
    fun destroy()
}