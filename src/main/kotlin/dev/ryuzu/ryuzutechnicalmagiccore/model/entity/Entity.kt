package dev.ryuzu.ryuzutechnicalmagiccore.model.entity

import dev.ryuzu.ryuzutechnicalmagiccore.model.configuration.base.ConfiguredDoubleLocation
import dev.ryuzu.ryuzutechnicalmagiccore.model.configuration.base.ConfiguredDoubleVector
import dev.ryuzu.ryuzutechnicalmagiccore.model.configuration.base.ConfiguredIntLocation
import dev.ryuzu.ryuzutechnicalmagiccore.model.configuration.base.ConfiguredIntVector
import dev.ryuzu.ryuzutechnicalmagiccore.util.wrapper.location.ILocationService
import dev.ryuzu.ryuzutechnicalmagiccore.util.wrapper.teleport.ITeleportService
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