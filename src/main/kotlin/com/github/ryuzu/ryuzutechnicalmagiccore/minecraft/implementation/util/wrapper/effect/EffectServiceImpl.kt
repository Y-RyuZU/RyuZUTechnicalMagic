package com.github.ryuzu.ryuzutechnicalmagiccore.minecraft.implementation.util.wrapper.effect

import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.base.ConfiguredDoubleLocation
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.base.ConfiguredDoubleVector
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.util.ConfiguredEffect
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.entity.IPlayer
import com.github.ryuzu.ryuzutechnicalmagiccore.core.util.scheduler.IParticleScheduler
import com.github.ryuzu.ryuzutechnicalmagiccore.core.util.scheduler.SimpleSchedulerFactory
import com.github.ryuzu.ryuzutechnicalmagiccore.core.util.scheduler.TaskUnit
import com.github.ryuzu.ryuzutechnicalmagiccore.core.util.wrapper.effect.IEffectService
import com.github.ryuzu.ryuzutechnicalmagiccore.core.util.wrapper.particle.IParticleService
import com.github.ryuzu.ryuzutechnicalmagiccore.core.util.wrapper.sound.ISoundService
import org.koin.core.annotation.Single
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

@Single([IEffectService::class])
class EffectServiceImpl : IEffectService, KoinComponent {
    private val schedulerFactory: SimpleSchedulerFactory by inject()
    private val particleService: IParticleService by inject()
    private val soundService: ISoundService by inject()

    override fun convertTaskUnits(
        effect: ConfiguredEffect,
        id: String,
        location: ConfiguredDoubleLocation,
        vector: ConfiguredDoubleVector,
        scheduler: IParticleScheduler
    ): Set<TaskUnit> =
        sequenceOf(
            effect.particles[id]?.let { particleService.convertTaskUnits(it, location, vector, scheduler) },
            effect.sounds[id]?.let { soundService.convertTaskUnits(it, location) }
        ).filterNotNull().flatten().toSet()

    override fun playEffect(
        effect: ConfiguredEffect,
        id: String,
        location: ConfiguredDoubleLocation,
        vector: ConfiguredDoubleVector,
        scheduler: IParticleScheduler
    ) {
        schedulerFactory.createScheduler().schedule(convertTaskUnits(effect, id, location, vector, scheduler)).runSync()
    }

    override fun convertTaskUnits(effect: ConfiguredEffect, id: String, scheduler: IParticleScheduler, players: Set<IPlayer>): Set<TaskUnit> =
        sequenceOf(
            effect.particles[id]?.let { particleService.convertTaskUnits(it, scheduler, players) },
            effect.sounds[id]?.let { soundService.convertTaskUnits(it, players) }
        ).filterNotNull().flatten().toSet()

    override fun playEffect(effect: ConfiguredEffect, id: String, players: Set<IPlayer>) {
        schedulerFactory.createParticleScheduler().apply {
            schedule(convertTaskUnits(effect, id, this, players)).runSync()
        }
    }
}