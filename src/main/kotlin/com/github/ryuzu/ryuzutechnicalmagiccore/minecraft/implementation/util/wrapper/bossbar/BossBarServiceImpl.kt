package com.github.ryuzu.ryuzutechnicalmagiccore.minecraft.implementation.util.wrapper.bossbar

import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.util.bossbar.ConfiguredBossBar
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.entity.IPlayer
import com.github.ryuzu.ryuzutechnicalmagiccore.core.util.StringUtility.Companion.replaceLambdaPlaceholders
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.scheduler.UpdatePeriod
import com.github.ryuzu.ryuzutechnicalmagiccore.core.util.wrapper.bossbar.AbstractBossBarService
import com.github.ryuzu.ryuzutechnicalmagiccore.core.util.wrapper.bossbar.IBossBarService
import com.github.ryuzu.ryuzutechnicalmagiccore.minecraft.util.BossBarBuilder
import com.github.ryuzu.ryuzutechnicalmagiccore.minecraft.util.EntityUtility.Companion.toPlayer
import net.kyori.adventure.bossbar.BossBar
import net.kyori.adventure.text.Component
import org.bukkit.Bukkit
import org.koin.core.annotation.Factory
import org.koin.core.component.inject

@Factory([IBossBarService::class])
class BossBarServiceImpl : AbstractBossBarService() {
    private val bossBarBuilder: BossBarBuilder by inject()
    private lateinit var bossBar: BossBar
    private val players: MutableSet<IPlayer> = mutableSetOf()

    override fun createBossBar(config: ConfiguredBossBar, placeholders: Map<String, () -> String>, period: UpdatePeriod): IBossBarService {
        this.bossBar = bossBarBuilder
            .color(BossBar.Color.valueOf(config.color.uppercase()))
            .style(BossBar.Overlay.valueOf(config.style.uppercase()))
            .progress(1F)
            .build()
        update(config.titles.first(), placeholders)
        super.createBossBar(config, placeholders, period)
        return this
    }

    override fun update(title: String, placeholders: Map<String, () -> String>) {
        bossBar.name(Component.text(title.replaceLambdaPlaceholders(placeholders)))
    }

    override fun destroy() {
        super.destroy()
        Bukkit.getOnlinePlayers().forEach {
            bossBar.removeViewer(it)
        }
    }

    override fun addPlayers(players: Set<IPlayer>) {
        players.forEach {
            bossBar.addViewer(it.toPlayer())
        }
        this.players.addAll(players)
    }

    override fun removePlayers(players: Set<IPlayer>) {
        players.forEach { bossBar.removeViewer(it.toPlayer()) }
        this.players.removeAll(players)
    }

    override fun progress(progress: Float) {
        bossBar.progress(progress.coerceIn(0F, 1F))
    }

    override fun color(color: String) {
        bossBar.color(BossBar.Color.valueOf(color.uppercase()))
    }
}