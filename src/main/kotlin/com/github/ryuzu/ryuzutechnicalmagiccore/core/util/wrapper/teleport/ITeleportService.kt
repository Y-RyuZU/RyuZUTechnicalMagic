package com.github.ryuzu.ryuzutechnicalmagiccore.core.util.wrapper.teleport

import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.base.ConfiguredIntLocation
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.base.ConfiguredIntVector
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.player.IPlayer
import org.koin.core.component.KoinComponent
import java.util.UUID

interface ITeleportService : KoinComponent {
    fun teleport(location: ConfiguredIntLocation, players: Set<IPlayer>)
    fun teleport(location: ConfiguredIntLocation, vararg players: IPlayer)
    fun teleport(location: ConfiguredIntVector, players: Set<IPlayer>)
    fun teleport(location: ConfiguredIntVector, vararg players: IPlayer)
}