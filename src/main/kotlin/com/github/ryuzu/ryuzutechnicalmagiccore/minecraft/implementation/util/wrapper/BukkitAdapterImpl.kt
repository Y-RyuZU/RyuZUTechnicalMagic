package com.github.ryuzu.ryuzutechnicalmagiccore.minecraft.implementation.util.wrapper

import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.player.IPlayer
import com.github.ryuzu.ryuzutechnicalmagiccore.core.util.wrapper.IBukkitAdapter
import com.github.ryuzu.ryuzutechnicalmagiccore.minecraft.util.PlayerUtility.Companion.toPlayer
import org.koin.core.annotation.Single

@Single
class BukkitAdapterImpl : IBukkitAdapter {
    override fun getName(player: IPlayer): String {
        return player.toPlayer().name
    }

}