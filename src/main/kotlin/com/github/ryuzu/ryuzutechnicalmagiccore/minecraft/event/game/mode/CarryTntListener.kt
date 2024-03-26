package com.github.ryuzu.ryuzutechnicalmagiccore.minecraft.event.game.mode

import com.hakan.basicdi.annotations.Component
import com.hakan.spinjection.listener.annotations.EventListener
import org.bukkit.event.player.PlayerInteractEvent

@Component
class CarryTntListener {

    @EventListener
    fun onPlayerMove(event: PlayerInteractEvent) {
        TODO()
    }
}