package com.github.ryuzu.ryuzutechnicalmagiccore.core.util.wrapper.location

import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.base.ConfiguredDoubleLocation
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.base.ConfiguredDoubleVector
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.base.ConfiguredIntLocation
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.player.IPlayer

interface ILocationService {
    fun getIntLocation(player: IPlayer): ConfiguredIntLocation
    fun getDoubleLocation(player: IPlayer): ConfiguredDoubleLocation
    fun getDirection(player: IPlayer): ConfiguredDoubleVector
}