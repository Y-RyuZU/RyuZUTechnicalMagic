package dev.ryuzu.ryuzutechnicalmagic.minecraft.paper.implementation.util.wrapper.scoreboard

import dev.ryuzu.ryuzutechnicalmagic.api.core.configuration.game.mode.ConfiguredScoreboard
import dev.ryuzu.ryuzutechnicalmagic.api.core.model.entity.IPlayer
import dev.ryuzu.ryuzutechnicalmagic.api.core.model.scheduler.ISchedulerFactory
import dev.ryuzu.ryuzutechnicalmagic.api.core.model.scheduler.ISimpleScheduler
import dev.ryuzu.ryuzutechnicalmagic.api.core.model.scheduler.UpdatePeriod
import dev.ryuzu.ryuzutechnicalmagic.api.core.util.StringUtility.Companion.replaceLambdaPlaceholders
import dev.ryuzu.ryuzutechnicalmagic.api.minecraft.adapter.scoreboard.IScoreboardObject
import dev.ryuzu.ryuzutechnicalmagic.minecraft.paper.util.EntityUtility.Companion.toPlayer
import net.kyori.adventure.text.Component
import net.megavex.scoreboardlibrary.api.ScoreboardLibrary
import net.megavex.scoreboardlibrary.api.sidebar.Sidebar
import org.koin.core.annotation.Factory
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

@Factory([IScoreboardObject::class])
class ScoreboardObjectImpl : IScoreboardObject, KoinComponent {
    private val scoreboardLibrary: ScoreboardLibrary by inject()
    private lateinit var scoreboard: Sidebar
    private val schedulerFactory: ISchedulerFactory by inject()
    private lateinit var scheduler: ISimpleScheduler

    override fun initialize(scoreboard: List<ConfiguredScoreboard>, placeholders: Map<String, () -> String>, period: UpdatePeriod): IScoreboardObject {
        scoreboardLibrary.createSidebar()
        this.scoreboard = scoreboardLibrary.createSidebar()
        update(scoreboard.first().title, scoreboard.first().lines, placeholders)
        scheduler = schedulerFactory.createSimpleScheduler(period).whileSchedule{ _, count ->
            val frame = ((count / period.getPeriod()) % scoreboard.size).toInt()
            update(scoreboard[frame].title, scoreboard[frame].lines, placeholders)
        }.runSync()
        return this
    }

    override fun destroy() {
        scheduler.cancel()
        scoreboard.close()
    }

    override fun addPlayers(vararg players: IPlayer) {
        scoreboard.addPlayers(players.map { it.toPlayer() })
    }

    override fun removePlayers(vararg players: IPlayer) {
        scoreboard.removePlayers(players.map { it.toPlayer() })
    }

    private fun update(title: String, lines: List<String>, placeholders: Map<String, () -> String>) {
        scoreboard.title(Component.text(title.replaceLambdaPlaceholders(placeholders)))

        lines.replaceLambdaPlaceholders(placeholders).forEachIndexed { index, line ->
            scoreboard.line(index, Component.text(line))
        }
    }
}