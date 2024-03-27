package com.github.ryuzu.ryuzutechnicalmagiccore.minecraft.implementation.util.wrapper.bossbar

import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.util.bossbar.ConfiguredBossBar
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.player.IPlayer
import com.github.ryuzu.ryuzutechnicalmagiccore.core.util.StringUtility.Companion.replaceLambdaPlaceholders
import com.github.ryuzu.ryuzutechnicalmagiccore.core.util.scheduler.UpdatePeriod
import com.github.ryuzu.ryuzutechnicalmagiccore.core.util.wrapper.bossbar.AbstractBossBarService
import com.github.ryuzu.ryuzutechnicalmagiccore.core.util.wrapper.bossbar.IBossBarService
import com.github.ryuzu.ryuzutechnicalmagiccore.minecraft.util.BossBarBuilder
import com.github.ryuzu.ryuzutechnicalmagiccore.minecraft.util.PlayerUtility.Companion.toPlayer
import org.bukkit.boss.BarColor
import org.bukkit.boss.BarStyle
import org.bukkit.boss.BossBar
import org.koin.core.annotation.Factory
import org.koin.core.component.inject

@Factory
class BossBarServiceImpl : AbstractBossBarService() {
    private val bossBarBuilder: BossBarBuilder by inject()
    private lateinit var bossBar: BossBar

    override fun createBossBar(config: ConfiguredBossBar, placeholders: Map<String, () -> String>, period: UpdatePeriod): IBossBarService {
        super.createBossBar(config, placeholders, period)
        this.bossBar = bossBarBuilder
            .color(BarColor.valueOf(config.color))
            .style(BarStyle.valueOf(config.style))
            .progress(1.0)
            .build()
        update(config.titles.first(), placeholders)
        return this
    }

    override fun update(title: String, placeholders: Map<String, () -> String>) {
        bossBar.setTitle(title.replaceLambdaPlaceholders(placeholders))
    }

    override fun destroy() {
        bossBar.removeAll()
    }

    override fun addPlayers(players: Set<IPlayer>) {
        players.forEach { bossBar.addPlayer(it.toPlayer()) }
    }

    override fun removePlayers(players: Set<IPlayer>) {
        players.forEach { bossBar.removePlayer(it.toPlayer()) }
    }

    override fun progress(progress: Double) {
        bossBar.progress = progress.coerceIn(0.0, 1.0)
    }

    override fun color(color: String) {
        bossBar.color = BarColor.valueOf(color)
    }
}