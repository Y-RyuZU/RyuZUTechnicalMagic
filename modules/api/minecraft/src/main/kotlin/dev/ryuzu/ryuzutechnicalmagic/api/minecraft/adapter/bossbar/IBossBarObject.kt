package dev.ryuzu.ryuzutechnicalmagic.api.minecraft.adapter.bossbar

import dev.ryuzu.ryuzutechnicalmagic.api.core.configuration.util.bossbar.ConfiguredBossBar
import dev.ryuzu.ryuzutechnicalmagic.api.core.model.entity.IPlayer
import dev.ryuzu.ryuzutechnicalmagic.api.core.model.scheduler.UpdatePeriod

interface IBossBarObject {
    fun initialize(config: ConfiguredBossBar, placeholders: Map<String, () -> String>, period: UpdatePeriod)
    fun addPlayers(vararg players: IPlayer)
    fun removePlayers(vararg players: IPlayer)
    fun destroy()
    fun progress(progress: Float)
    fun color(color: String)
}