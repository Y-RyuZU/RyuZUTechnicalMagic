package com.github.ryuzu.ryuzutechnicalmagiccore.minecraft.util

import org.bukkit.Bukkit
import org.bukkit.entity.Player
import java.util.*

class PlayerUtility {
    companion object {
        fun UUID.toPlayer(): Player {
            return Bukkit.getPlayer(this)!!
        }
    }
}