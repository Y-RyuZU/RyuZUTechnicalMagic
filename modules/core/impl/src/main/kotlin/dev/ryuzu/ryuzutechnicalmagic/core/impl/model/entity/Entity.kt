package dev.ryuzu.ryuzutechnicalmagic.core.impl.model.entity

import dev.ryuzu.ryuzutechnicalmagic.api.core.model.configuration.base.ConfiguredDoubleLocation
import dev.ryuzu.ryuzutechnicalmagic.api.core.model.configuration.base.ConfiguredDoubleVector
import dev.ryuzu.ryuzutechnicalmagic.api.core.model.configuration.base.ConfiguredIntLocation
import dev.ryuzu.ryuzutechnicalmagic.api.core.configuration.data.base.ConfiguredIntVector
import dev.ryuzu.ryuzutechnicalmagic.api.core.model.entity.IEntity
import dev.ryuzu.ryuzutechnicalmagic.api.minecraft.adapter.location.ILocationAdapter
import dev.ryuzu.ryuzutechnicalmagic.api.minecraft.adapter.teleport.ITeleportService
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import java.util.*

class Entity(override val id: UUID) : IEntity, KoinComponent {
    private val teleportService: ITeleportService by inject()
    private val locationService: ILocationAdapter by inject()

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