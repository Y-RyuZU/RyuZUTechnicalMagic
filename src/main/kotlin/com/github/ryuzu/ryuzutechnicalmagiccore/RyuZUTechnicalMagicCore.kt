package com.github.ryuzu.ryuzutechnicalmagiccore

import com.onarandombox.MultiverseCore.MultiverseCore
import net.megavex.scoreboardlibrary.api.ScoreboardLibrary
import org.bukkit.Bukkit
import org.bukkit.NamespacedKey
import org.bukkit.plugin.java.JavaPlugin
import org.koin.core.annotation.ComponentScan
import org.koin.core.annotation.Module
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
@Module
@ComponentScan("com.github.ryuzu.ryuzutechnicalmagiccore")
class RyuZUTechnicalMagicCore : JavaPlugin() {
    override fun onEnable() {
        // Plugin startup logic

    }

    override fun onDisable() {
        // Plugin shutdown logic
        provideScoreboardLibrary().close()
    }

    fun provideInstance() = this
    fun provideNamespacedKey() = NamespacedKey(this, this.name)
    fun provideScoreboardLibrary() = ScoreboardLibrary.loadScoreboardLibrary(this);
    fun provideMultiverseCore() = Bukkit.getServer().pluginManager.getPlugin("Multiverse-Core") as MultiverseCore
    fun provideMVWorldManager() = provideMultiverseCore().mvWorldManager
}
