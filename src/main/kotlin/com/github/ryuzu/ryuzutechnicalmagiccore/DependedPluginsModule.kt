package com.github.ryuzu.ryuzutechnicalmagiccore

import com.onarandombox.MultiverseCore.MultiverseCore
import net.megavex.scoreboardlibrary.api.ScoreboardLibrary
import org.bukkit.Bukkit
import org.bukkit.NamespacedKey
import org.koin.core.annotation.ComponentScan
import org.koin.core.annotation.Module

import org.koin.core.annotation.Single
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

@Module
class DependedPluginsModule : KoinComponent {
    private val instance: RyuZUTechnicalMagicCore by inject()

    @Single(createdAtStart = true)
    fun provideScoreboardLibrary() = ScoreboardLibrary.loadScoreboardLibrary(instance);
    @Single
    fun provideMultiverseCore() = Bukkit.getServer().pluginManager.getPlugin("Multiverse-Core") as MultiverseCore
    @Single
    fun provideMVWorldManager() = provideMultiverseCore().mvWorldManager
}