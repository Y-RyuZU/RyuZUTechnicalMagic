package com.github.ryuzu.ryuzutechnicalmagiccore.core.model.entity

import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.base.ConfiguredDoubleLocation
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.base.ConfiguredDoubleVector
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.base.ConfiguredIntLocation
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.base.ConfiguredIntVector
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.entity.effect.IStatusEffectContainer
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.entity.effect.StatusEffectContainer
import com.github.ryuzu.ryuzutechnicalmagiccore.core.util.wrapper.location.ILocationService
import com.github.ryuzu.ryuzutechnicalmagiccore.core.util.wrapper.teleport.ITeleportService
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import java.util.*

data class Entity(override val id: UUID) : IEntity, KoinComponent {
    private val teleportService: ITeleportService by inject()
    private val locationService: ILocationService by inject()

    override fun teleport(location: ConfiguredIntLocation) {
        teleportService.teleport(location, this)
    }

    override fun teleport(vector: ConfiguredIntVector) {
        teleportService.teleport(vector, this)
    }

    override fun getIntLocation(): ConfiguredIntLocation = locationService.getIntLocation(this)
    override fun getDoubleLocation(): ConfiguredDoubleLocation = locationService.getDoubleLocation(this)
    override fun getDirection(): ConfiguredDoubleVector = locationService.getDirection(this)
}