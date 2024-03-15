package com.github.ryuzu.ryuzutechnicalmagiccore

import org.bukkit.plugin.java.JavaPlugin

class RyuZUTechnicalMagicCore : JavaPlugin() {
    companion object {
        lateinit var instance: RyuZUTechnicalMagicCore
    }

    override fun onEnable() {
        // Plugin startup logic
        instance = this
    }

    override fun onDisable() {
        // Plugin shutdown logic
    }
}
