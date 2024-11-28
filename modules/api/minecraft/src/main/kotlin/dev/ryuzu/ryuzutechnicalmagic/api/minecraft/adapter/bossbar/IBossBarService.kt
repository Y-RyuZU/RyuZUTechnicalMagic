package dev.ryuzu.ryuzutechnicalmagic.api.minecraft.adapter.bossbar

import dev.ryuzu.ryuzutechnicalmagic.api.core.model.configuration.util.bossbar.ConfiguredBossBar
import dev.ryuzu.ryuzutechnicalmagic.api.core.model.scheduler.UpdatePeriod


interface IBossBarService {
    fun createBossBar(config: ConfiguredBossBar, placeholders: Map<String, () -> String>, period: UpdatePeriod = UpdatePeriod.SECOND): IBossBarService
    fun addPlayers(players: Set<dev.ryuzu.ryuzutechnicalmagic.api.core.model.entity.IPlayer>)
    fun addPlayers(vararg players: dev.ryuzu.ryuzutechnicalmagic.api.core.model.entity.IPlayer) = addPlayers(players.toSet())
    fun removePlayers(players: Set<dev.ryuzu.ryuzutechnicalmagic.api.core.model.entity.IPlayer>)
    fun removePlayers(vararg players: dev.ryuzu.ryuzutechnicalmagic.api.core.model.entity.IPlayer) = removePlayers(players.toSet())
    fun destroy()
    fun progress(progress: Float)
    fun color(color: String)
}