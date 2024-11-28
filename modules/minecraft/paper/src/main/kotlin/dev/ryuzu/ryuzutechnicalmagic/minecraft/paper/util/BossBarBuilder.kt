package dev.ryuzu.ryuzutechnicalmagic.minecraft.paper.util

import net.kyori.adventure.bossbar.BossBar
import net.kyori.adventure.text.Component
import org.bukkit.Bukkit
import org.bukkit.NamespacedKey
import org.koin.core.annotation.Single
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

@Single
class BossBarBuilder : KoinComponent {
    private val namespacedKey: NamespacedKey by inject()

    private var title: String = ""
    private var color: BossBar.Color = BossBar.Color.WHITE
    private var style: BossBar.Overlay = BossBar.Overlay.PROGRESS
    private var progress: Float = 1F

    fun title(title: String): BossBarBuilder {
        this.title = title
        return this
    }

    fun color(color: BossBar.Color): BossBarBuilder {
        this.color = color
        return this
    }

    fun style(style: BossBar.Overlay): BossBarBuilder {
        this.style = style
        return this
    }

    fun progress(progress: Float): BossBarBuilder {
        this.progress = progress.coerceIn(0F, 1F) // Ensure progress is within 0.0 and 1.0.
        return this
    }

    fun build(): BossBar {
        val bossBar = BossBar.bossBar(Component.text(title), progress, color, style)
        return bossBar
    }
}