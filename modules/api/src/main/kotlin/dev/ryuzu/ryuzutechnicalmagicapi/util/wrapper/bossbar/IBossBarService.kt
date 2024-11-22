package dev.ryuzu.ryuzutechnicalmagicapi.util.wrapper.bossbar

import dev.ryuzu.ryuzutechnicalmagicapi.model.configuration.util.bossbar.ConfiguredBossBar
import dev.ryuzu.ryuzutechnicalmagicapi.model.entity.IPlayer
import dev.ryuzu.ryuzutechnicalmagicapi.model.scheduler.UpdatePeriod


interface IBossBarService {
    fun createBossBar(config: ConfiguredBossBar, placeholders: Map<String, () -> String>, period: UpdatePeriod = UpdatePeriod.SECOND): IBossBarService
    fun addPlayers(players: Set<IPlayer>)
    fun addPlayers(vararg players: IPlayer) = addPlayers(players.toSet())
    fun removePlayers(players: Set<IPlayer>)
    fun removePlayers(vararg players: IPlayer) = removePlayers(players.toSet())
    fun destroy()
    fun progress(progress: Float)
    fun color(color: String)
}