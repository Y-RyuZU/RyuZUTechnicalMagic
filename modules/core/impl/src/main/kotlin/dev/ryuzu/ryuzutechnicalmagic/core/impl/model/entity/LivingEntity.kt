package dev.ryuzu.ryuzutechnicalmagic.core.impl.model.entity

import dev.ryuzu.ryuzutechnicalmagic.api.core.model.configuration.base.ConfiguredDoubleLocation
import dev.ryuzu.ryuzutechnicalmagic.api.core.model.configuration.base.ConfiguredDoubleVector
import dev.ryuzu.ryuzutechnicalmagic.api.core.model.entity.IEntity
import dev.ryuzu.ryuzutechnicalmagic.api.core.model.entity.ILivingEntity
import dev.ryuzu.ryuzutechnicalmagic.core.impl.model.entity.effect.StatusEffectContainer
import dev.ryuzu.ryuzutechnicalmagic.api.minecraft.adapter.location.ILocationService
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class LivingEntity(entity: IEntity) : ILivingEntity, IEntity by entity, KoinComponent {
    val statusEffectContainer = StatusEffectContainer()
    private val locationService: ILocationService by inject()

    override fun getEyeLocation(): ConfiguredDoubleLocation = locationService.getEyeLocation(this)
    override fun getEyeDirection(): ConfiguredDoubleVector = locationService.getEyeDirection(this)
}