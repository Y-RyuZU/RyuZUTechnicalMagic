package dev.ryuzu.ryuzutechnicalmagic.minecraft.paper.implementation.util.wrapper.bossbar

import dev.ryuzu.ryuzutechnicalmagic.api.core.configuration.util.bossbar.ConfiguredBossBar
import dev.ryuzu.ryuzutechnicalmagic.api.core.model.entity.IPlayer
import dev.ryuzu.ryuzutechnicalmagic.api.core.model.scheduler.ISchedulerFactory
import dev.ryuzu.ryuzutechnicalmagic.api.core.model.scheduler.ISimpleScheduler
import dev.ryuzu.ryuzutechnicalmagic.api.core.model.scheduler.UpdatePeriod
import dev.ryuzu.ryuzutechnicalmagic.api.core.util.StringUtility.Companion.replaceLambdaPlaceholders
import dev.ryuzu.ryuzutechnicalmagic.api.minecraft.adapter.bossbar.IBossBarObject
import dev.ryuzu.ryuzutechnicalmagic.minecraft.paper.util.BossBarBuilder
import dev.ryuzu.ryuzutechnicalmagic.minecraft.paper.util.EntityUtility.Companion.toPlayer
import net.kyori.adventure.bossbar.BossBar
import net.kyori.adventure.text.Component
import org.bukkit.Bukkit
import org.koin.core.annotation.Factory
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

@Factory([IBossBarObject::class])
class BossBarObjectImpl : IBossBarObject, KoinComponent {
    private val schedulerFactory: ISchedulerFactory by inject()
    private lateinit var scheduler: ISimpleScheduler

    private val bossBarBuilder: BossBarBuilder by inject()
    private lateinit var bossBar: BossBar
    private val players: MutableSet<IPlayer> = mutableSetOf()

    override fun initialize(config: ConfiguredBossBar, placeholders: Map<String, () -> String>, period: UpdatePeriod) {
        this.bossBar = bossBarBuilder
            .color(BossBar.Color.valueOf(config.color.uppercase()))
            .style(BossBar.Overlay.valueOf(config.style.uppercase()))
            .progress(1F)
            .build()
        update(config.titles.first(), placeholders)

        scheduler = schedulerFactory.createSimpleScheduler(period).whileSchedule { _, count ->
            val frame = ((count / period.getPeriod()) % config.titles.size).toInt()
            update(config.titles[frame], placeholders)
        }.runSync()
    }

    override fun destroy() {
        scheduler.cancel()
        Bukkit.getOnlinePlayers().forEach {
            bossBar.removeViewer(it)
        }
    }

    override fun addPlayers(vararg players: IPlayer) {
        players.forEach {
            bossBar.addViewer(it.toPlayer())
        }
        this.players.addAll(players)
    }

    override fun removePlayers(vararg players: IPlayer) {
        players.forEach { bossBar.removeViewer(it.toPlayer()) }
        this.players.removeAll(players)
    }

    override fun progress(progress: Float) {
        bossBar.progress(progress.coerceIn(0F, 1F))
    }

    override fun color(color: String) {
        bossBar.color(BossBar.Color.valueOf(color.uppercase()))
    }

    private fun update(title: String, placeholders: Map<String, () -> String>) {
        bossBar.name(Component.text(title.replaceLambdaPlaceholders(placeholders)))
    }
}