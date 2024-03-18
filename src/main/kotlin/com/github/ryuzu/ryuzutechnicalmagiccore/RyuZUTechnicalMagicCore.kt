package com.github.ryuzu.ryuzutechnicalmagiccore

import org.bukkit.NamespacedKey
import org.bukkit.plugin.java.JavaPlugin
import org.koin.core.annotation.ComponentScan
import org.koin.core.annotation.Module

@Module
@ComponentScan("com.github.ryuzu.ryuzutechnicalmagiccore")
class RyuZUTechnicalMagicCore : JavaPlugin() {
    override fun onEnable() {
        // Plugin startup logic

    }

    override fun onDisable() {
        // Plugin shutdown logic
    }

    fun provideInstance() = this
    fun provideNamespacedKey() = NamespacedKey(this, this.name)
}
