package com.github.ryuzu.ryuzutechnicalmagiccore.minecraft.event

import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.player.service.IPlayerLoginService
import com.github.ryuzu.ryuzutechnicalmagiccore.minecraft.implementation.PlayerLoginServiceImpl
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerJoinEvent


class PlayerLoginListener(
    private val playerLoginService: IPlayerLoginService
) : Listener {
    @EventHandler
    fun onPlayerJoin(event: PlayerJoinEvent) {
        val player = event.player
        playerLoginService.login()
    }
}