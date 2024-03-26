package com.github.ryuzu.ryuzutechnicalmagiccore.core.util.wrapper.bossbar

import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.util.bossbar.ConfiguredBossBar
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.player.IPlayer
import com.github.ryuzu.ryuzutechnicalmagiccore.core.util.scheduler.UpdatePeriod
import org.koin.core.component.KoinComponent
import java.util.UUID

interface IBossBarService : KoinComponent {
    fun createBossBar(bossBar: ConfiguredBossBar, placeholders: Map<String, () -> String>, period: UpdatePeriod = UpdatePeriod.SECOND): IBossBarService
    fun addPlayers(players: Set<IPlayer>)
    fun addPlayers(vararg players: IPlayer) = addPlayers(players.toSet())
    fun removePlayers(players: Set<IPlayer>)
    fun removePlayers(vararg players: IPlayer) = removePlayers(players.toSet())
    fun destroy()
    fun progress(progress: Double)
    fun color(color: String)
}