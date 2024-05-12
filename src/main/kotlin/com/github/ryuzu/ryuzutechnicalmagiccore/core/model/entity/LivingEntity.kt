package com.github.ryuzu.ryuzutechnicalmagiccore.core.model.entity

import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.base.ConfiguredDoubleLocation
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.base.ConfiguredDoubleVector
import com.github.ryuzu.ryuzutechnicalmagiccore.core.util.wrapper.location.ILocationService
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class LivingEntity(entity: IEntity) : ILivingEntity, IEntity by entity, KoinComponent {
    private val locationService: ILocationService by inject()

    override fun getEyeLocation(): ConfiguredDoubleLocation = locationService.getEyeLocation(this)

    override fun getEyeDirection(): ConfiguredDoubleVector = locationService.getEyeDirection(this)

}