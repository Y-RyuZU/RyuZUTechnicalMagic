package com.github.ryuzu.ryuzutechnicalmagiccore.core.util.particle

import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.base.ConfiguredDoubleLocation
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.base.ConfiguredIntLocation
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.util.particle.ConfiguredParticleSet
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.util.particle.IConfiguredParticle
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.game.player.IGamePlayer
import com.github.ryuzu.ryuzutechnicalmagiccore.core.util.scheduler.TaskUnit
import com.github.ryuzu.ryuzutechnicalmagiccore.minecraft.implementation.util.scheduler.SimpleSchedulerFactory
import org.koin.core.component.inject
import java.util.*

abstract class AbstractParticleService : IParticleService {
    private val schedulerFactory: SimpleSchedulerFactory by inject()

    override fun convertTaskUnits(particleSets: Set<ConfiguredParticleSet>, location: ConfiguredDoubleLocation, players: Set<UUID>): Set<TaskUnit> {
        return particleSets.flatMap { particleSet ->
            particleSet.particles.map { particle ->
                TaskUnit(particle.delay) { _, _ ->
                    players
                        .forEach {
                            spawnParticle(particle, location)
                        }
                }
            }
        }.toSet()
    }

    override fun spawnParticle(particleSet: Set<ConfiguredParticleSet>, location: ConfiguredDoubleLocation, players: Set<UUID>) {
        schedulerFactory.createScheduler().schedule(convertTaskUnits(particleSet,location , players)).runSync()
    }

    override fun spawnParticle(particleSet: Set<ConfiguredParticleSet>, location: ConfiguredDoubleLocation, vararg players: UUID) {
        schedulerFactory.createScheduler().schedule(convertTaskUnits(particleSet, location, players.toSet())).runSync()
    }

    protected abstract fun spawnParticle(particle: IConfiguredParticle, location: ConfiguredDoubleLocation)
}