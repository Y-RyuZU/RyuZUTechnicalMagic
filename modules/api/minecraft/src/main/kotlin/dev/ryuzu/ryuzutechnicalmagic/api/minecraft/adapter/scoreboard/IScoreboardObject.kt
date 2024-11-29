package dev.ryuzu.ryuzutechnicalmagic.api.minecraft.adapter.scoreboard

import dev.ryuzu.ryuzutechnicalmagic.api.core.configuration.game.mode.ConfiguredScoreboard
import dev.ryuzu.ryuzutechnicalmagic.api.core.model.entity.IPlayer
import dev.ryuzu.ryuzutechnicalmagic.api.core.model.scheduler.UpdatePeriod

interface IScoreboardObject {
    fun initialize(scoreboard: List<ConfiguredScoreboard>, placeholders: Map<String, () -> String>, period: UpdatePeriod = UpdatePeriod.SECOND): IScoreboardObject
    fun addPlayers(vararg players: IPlayer)
    fun removePlayers(vararg players: IPlayer)
    fun destroy()
}