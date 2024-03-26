package com.github.ryuzu.ryuzutechnicalmagiccore.minecraft.implementation.util.wrapper.teleport

import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.base.ConfiguredIntLocation
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.base.ConfiguredIntVector
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.player.IPlayer
import com.github.ryuzu.ryuzutechnicalmagiccore.core.util.wrapper.teleport.AbstractTeleportService
import com.github.ryuzu.ryuzutechnicalmagiccore.minecraft.util.ConfiguredUtility.Companion.toBlockLocation
import com.github.ryuzu.ryuzutechnicalmagiccore.minecraft.util.ConfiguredUtility.Companion.toMiddleLocation
import com.github.ryuzu.ryuzutechnicalmagiccore.minecraft.util.PlayerUtility.Companion.toPlayer
import org.koin.core.annotation.Single
import java.util.*

@Single
class TeleportServiceImpl : AbstractTeleportService() {
    override fun teleport(location: ConfiguredIntLocation, players: Set<IPlayer>) {
        players.map { it.toPlayer() }.forEach { it.teleport(location.toBlockLocation()) }
    }

    override fun teleport(location: ConfiguredIntVector, players: Set<IPlayer>) {
        players.map { it.toPlayer() }.forEach { it.teleport(location.toLocation(it.location.world.name).toMiddleLocation()) }
    }
}