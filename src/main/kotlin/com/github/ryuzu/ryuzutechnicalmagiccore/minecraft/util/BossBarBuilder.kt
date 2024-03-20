package com.github.ryuzu.ryuzutechnicalmagiccore.minecraft.util

import org.bukkit.Bukkit
import org.bukkit.NamespacedKey
import org.bukkit.boss.BarColor
import org.bukkit.boss.BarStyle
import org.bukkit.boss.BossBar
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class BossBarBuilder : KoinComponent {
    private val namespacedKey: NamespacedKey by inject()

    private var title: String = ""
    private var color: BarColor = BarColor.WHITE
    private var style: BarStyle = BarStyle.SOLID
    private var progress: Double = 1.0

    fun title(title: String): BossBarBuilder {
        this.title = title
        return this
    }

    fun color(color: BarColor): BossBarBuilder {
        this.color = color
        return this
    }

    fun style(style: BarStyle): BossBarBuilder {
        this.style = style
        return this
    }

    fun progress(progress: Double): BossBarBuilder {
        this.progress = progress.coerceIn(0.0, 1.0) // Ensure progress is within 0.0 and 1.0.
        return this
    }

    fun build(): BossBar {
        val bossBar =
            Bukkit.createBossBar(namespacedKey, title, color, style)
        bossBar.progress = progress
        return bossBar
    }
}