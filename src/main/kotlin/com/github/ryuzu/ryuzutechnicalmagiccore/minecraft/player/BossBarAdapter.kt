package com.github.ryuzu.ryuzutechnicalmagiccore.minecraft.player

import org.bukkit.Bukkit
import org.bukkit.boss.BarColor
import org.bukkit.boss.BarStyle
import org.bukkit.boss.BossBar

class BossBarAdapter {
    fun createBossBarAndAddPlayer(player: String, message: String) {
        val bossBar = Bukkit.createBossBar(message, BarColor.RED, BarStyle.SOLID)
        Bukkit.getPlayer(player)?.let { bossBar.addPlayer(it) }
    }
}