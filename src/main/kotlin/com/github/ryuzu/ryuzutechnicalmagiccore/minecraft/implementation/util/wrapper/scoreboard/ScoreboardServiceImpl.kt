package com.github.ryuzu.ryuzutechnicalmagiccore.minecraft.implementation.util.wrapper.scoreboard

import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.game.mode.ConfiguredScoreboard
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.util.bossbar.ConfiguredBossBar
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.player.IPlayer
import com.github.ryuzu.ryuzutechnicalmagiccore.core.util.StringUtility.Companion.replacePlaceholders
import com.github.ryuzu.ryuzutechnicalmagiccore.core.util.scheduler.UpdatePeriod
import com.github.ryuzu.ryuzutechnicalmagiccore.core.util.wrapper.bossbar.AbstractBossBarService
import com.github.ryuzu.ryuzutechnicalmagiccore.core.util.wrapper.bossbar.IBossBarService
import com.github.ryuzu.ryuzutechnicalmagiccore.core.util.wrapper.scoreboard.AbstractScoreboardService
import com.github.ryuzu.ryuzutechnicalmagiccore.core.util.wrapper.scoreboard.IScoreboardService
import com.github.ryuzu.ryuzutechnicalmagiccore.minecraft.util.BossBarBuilder
import com.github.ryuzu.ryuzutechnicalmagiccore.minecraft.util.ColorUtility
import com.github.ryuzu.ryuzutechnicalmagiccore.minecraft.util.PlayerUtility.Companion.toPlayer
import net.kyori.adventure.text.Component
import net.megavex.scoreboardlibrary.api.ScoreboardLibrary
import net.megavex.scoreboardlibrary.api.sidebar.Sidebar
import org.bukkit.boss.BarColor
import org.bukkit.boss.BarStyle
import org.bukkit.boss.BossBar
import org.koin.core.annotation.Factory
import org.koin.core.component.inject
import java.util.*

@Factory
class ScoreboardServiceImpl : AbstractScoreboardService() {
    private val scoreboardLibrary: ScoreboardLibrary by inject()
    private lateinit var scoreboard: Sidebar

    override fun createScoreboard(config: List<ConfiguredScoreboard>, placeholders: Map<String, () -> String>, period: UpdatePeriod): IScoreboardService {
        super.createScoreboard(config, placeholders, period)
        scoreboardLibrary.createSidebar()
        this.scoreboard = scoreboardLibrary.createSidebar()
        update(config.first().title, config.first().lines, placeholders)
        return this
    }

    override fun update(title: String, lines: List<String>, placeholders: Map<String, () -> String>) {
        scoreboard.title(Component.text(title.replacePlaceholders(placeholders)))

        lines.replacePlaceholders(placeholders).forEachIndexed { index, line ->
            scoreboard.line(index, Component.text(line))
        }
    }

    override fun destroy() {
        scoreboard.close()
    }

    override fun addPlayers(players: Set<IPlayer>) {
        scoreboard.addPlayers(players.map { it.toPlayer() })
    }

    override fun removePlayers(players: Set<IPlayer>) {
        scoreboard.removePlayers(players.map { it.toPlayer() })
    }
}