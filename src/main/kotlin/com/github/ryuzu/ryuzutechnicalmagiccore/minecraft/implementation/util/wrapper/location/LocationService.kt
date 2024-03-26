package com.github.ryuzu.ryuzutechnicalmagiccore.minecraft.implementation.util.wrapper.location

import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.base.ConfiguredDoubleLocation
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.base.ConfiguredIntLocation
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.player.IPlayer
import com.github.ryuzu.ryuzutechnicalmagiccore.core.util.wrapper.location.ILocationService
import com.github.ryuzu.ryuzutechnicalmagiccore.minecraft.util.ConfiguredUtility.Companion.toDoubleConfigured
import com.github.ryuzu.ryuzutechnicalmagiccore.minecraft.util.ConfiguredUtility.Companion.toIntConfigured
import com.github.ryuzu.ryuzutechnicalmagiccore.minecraft.util.PlayerUtility.Companion.toPlayer
import org.koin.core.annotation.Single
import java.util.*

@Single
class LocationService : ILocationService {
    override fun getIntLocation(player: IPlayer): ConfiguredIntLocation =
        player.toPlayer().getLocation().toIntConfigured()

    override fun getDoubleLocation(player: IPlayer): ConfiguredDoubleLocation =
        player.toPlayer().getLocation().toDoubleConfigured()

}