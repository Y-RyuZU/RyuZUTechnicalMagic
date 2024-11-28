package dev.ryuzu.ryuzutechnicalmagic.minecraft.paper

import com.onarandombox.MultiverseCore.MultiverseCore
import net.megavex.scoreboardlibrary.api.ScoreboardLibrary
import org.bukkit.Bukkit
import org.koin.core.annotation.Module

import org.koin.core.annotation.Single
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

@Module
class DependPluginsModule : KoinComponent {
    private val instance: dev.ryuzu.ryuzutechnicalmagic.minecraft.paper.RyuZUTechnicalMagic by inject()

    @Single(createdAtStart = true)
    fun provideScoreboardLibrary() = ScoreboardLibrary.loadScoreboardLibrary(instance)
    @Single
    fun provideMultiverseCore() = Bukkit.getServer().pluginManager.getPlugin("Multiverse-Core") as MultiverseCore
    @Single
    fun provideMVWorldManager() = provideMultiverseCore().mvWorldManager
}