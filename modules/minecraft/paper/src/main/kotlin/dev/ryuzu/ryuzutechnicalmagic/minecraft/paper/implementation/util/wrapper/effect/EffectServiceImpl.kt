package dev.ryuzu.ryuzutechnicalmagic.minecraft.paper.implementation.util.wrapper.effect

import dev.ryuzu.ryuzutechnicalmagic.api.core.data.base.SerDoubleLocation
import dev.ryuzu.ryuzutechnicalmagic.api.core.data.base.SerDoubleVector
import dev.ryuzu.ryuzutechnicalmagic.api.core.model.effect.IEffectService
import dev.ryuzu.ryuzutechnicalmagic.api.core.model.effect.IParticleService
import dev.ryuzu.ryuzutechnicalmagic.api.core.model.effect.ISoundService
import dev.ryuzu.ryuzutechnicalmagic.api.core.model.entity.IPlayer
import dev.ryuzu.ryuzutechnicalmagic.api.core.model.scheduler.IParticleScheduler
import dev.ryuzu.ryuzutechnicalmagic.api.core.model.scheduler.ISchedulerFactory
import dev.ryuzu.ryuzutechnicalmagic.api.core.model.scheduler.TaskUnit

@Single([IEffectService::class])
class EffectServiceImpl : IEffectService, KoinComponent {
    private val schedulerFactory: ISchedulerFactory by inject()
    private val particleService: IParticleService by inject()
    private val soundService: ISoundService by inject()

    override fun convertTaskUnits(
        effect: ConfiguredEffect,
        id: String,
        location: SerDoubleLocation,
        vector: SerDoubleVector,
        scheduler: IParticleScheduler
    ): Set<TaskUnit> =
        sequenceOf(
            effect.particles[id]?.let { particleService.convertTaskUnits(it, location, vector, scheduler) },
            effect.sounds[id]?.let { soundService.convertTaskUnits(it, location) }
        ).filterNotNull().flatten().toSet()

    override fun playEffect(
        effect: ConfiguredEffect,
        id: String,
        location: SerDoubleLocation,
        vector: SerDoubleVector,
        scheduler: IParticleScheduler
    ) {
        schedulerFactory.createSimpleScheduler().schedule(convertTaskUnits(effect, id, location, vector, scheduler)).runSync()
    }

    override fun convertTaskUnits(effect: ConfiguredEffect, id: String, scheduler: IParticleScheduler, vararg players: IPlayer): Set<TaskUnit> =
        sequenceOf(
            effect.particles[id]?.let { particleService.convertTaskUnits(it, scheduler, *players) },
            effect.sounds[id]?.let { soundService.convertTaskUnits(it, *players) }
        ).filterNotNull().flatten().toSet()

    override fun playEffect(effect: ConfiguredEffect, id: String, vararg players: IPlayer) {
        schedulerFactory.createParticleScheduler().apply {
            schedule(convertTaskUnits(effect, id, this, *players)).runSync()
        }
    }
}