package dev.ryuzu.ryuzutechnicalmagiccore.model.entity

import dev.ryuzu.ryuzutechnicalmagiccore.model.configuration.base.ConfiguredDoubleLocation
import dev.ryuzu.ryuzutechnicalmagiccore.model.configuration.base.ConfiguredDoubleVector
import dev.ryuzu.ryuzutechnicalmagiccore.model.entity.effect.StatusEffectContainer
import dev.ryuzu.ryuzutechnicalmagiccore.model.entity.effect.StatusEffectId
import dev.ryuzu.ryuzutechnicalmagiccore.model.entity.effect.StatusEffectState
import dev.ryuzu.ryuzutechnicalmagiccore.util.wrapper.location.ILocationService
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class LivingEntity(entity: IEntity) : ILivingEntity, IEntity by entity, KoinComponent {
    val statusEffectContainer = StatusEffectContainer()
    private val locationService: ILocationService by inject()

    override fun getEyeLocation(): ConfiguredDoubleLocation = locationService.getEyeLocation(this)
    override fun getEyeDirection(): ConfiguredDoubleVector = locationService.getEyeDirection(this)
}