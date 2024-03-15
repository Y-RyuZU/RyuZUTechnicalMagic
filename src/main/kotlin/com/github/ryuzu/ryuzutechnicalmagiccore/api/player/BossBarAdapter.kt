package com.github.ryuzu.ryuzutechnicalmagiccore.api.player

import org.bukkit.Bukkit
import org.bukkit.boss.BarColor
import org.bukkit.boss.BarStyle

class BossBarAdapter {
    fun createBossBarAndAddPlayer(player: String, message: String) {
        val bossBar = Bukkit.createBossBar(message, BarColor.RED, BarStyle.SOLID)
        Bukkit.getPlayer(player)?.let { bossBar.addPlayer(it) }
    }
}