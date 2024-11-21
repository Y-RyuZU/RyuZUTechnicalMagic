package dev.ryuzu.ryuzutechnicalmagiccore.util.wrapper.bossbar

import dev.ryuzu.ryuzutechnicalmagiccore.model.configuration.util.bossbar.ConfiguredBossBar
import dev.ryuzu.ryuzutechnicalmagiccore.model.entity.IPlayer
import dev.ryuzu.ryuzutechnicalmagiccore.model.scheduler.UpdatePeriod
import org.koin.core.component.KoinComponent

interface IBossBarService : KoinComponent {
    fun createBossBar(config: ConfiguredBossBar, placeholders: Map<String, () -> String>, period: UpdatePeriod = UpdatePeriod.SECOND): IBossBarService
    fun addPlayers(players: Set<IPlayer>)
    fun addPlayers(vararg players: IPlayer) = addPlayers(players.toSet())
    fun removePlayers(players: Set<IPlayer>)
    fun removePlayers(vararg players: IPlayer) = removePlayers(players.toSet())
    fun destroy()
    fun progress(progress: Float)
    fun color(color: String)
}