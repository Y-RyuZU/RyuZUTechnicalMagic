package com.github.ryuzu.ryuzutechnicalmagiccore.core.util.wrapper.particle

import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.base.ConfiguredDoubleLocation
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.base.ConfiguredDoubleVector
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.base.ConfiguredIntLocation
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.util.particle.ConfiguredParticleSet
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.util.particle.IConfiguredParticle
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.game.player.IGamePlayer
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.player.IPlayer
import com.github.ryuzu.ryuzutechnicalmagiccore.core.util.scheduler.TaskUnit
import com.github.ryuzu.ryuzutechnicalmagiccore.core.util.wrapper.location.ILocationService
import com.github.ryuzu.ryuzutechnicalmagiccore.core.util.scheduler.SimpleSchedulerFactory
import org.koin.core.component.inject

abstract class AbstractParticleService : IParticleService {
    private val schedulerFactory: SimpleSchedulerFactory by inject()
    private val locationService: ILocationService by inject()


    override fun convertTaskUnits(
        particleSets: Set<ConfiguredParticleSet>,
        location: ConfiguredDoubleLocation,
        vector: ConfiguredDoubleVector,
        receivers: Set<IPlayer>
    ): Set<TaskUnit> {
        val verticalVector = ConfiguredDoubleVector(0.0, 1.0, 0.0)
        return particleSets.flatMap { particleSet ->
            particleSet.particles.map { particle ->
                TaskUnit(particle.delay) { _, _ ->
                    spawnParticle(particle, location, if (particleSet.vertical) verticalVector else vector, receivers)
                }
            }
        }.toSet()
    }

    override fun convertTaskUnits(
        particleSets: Set<ConfiguredParticleSet>,
        receivers: Set<IPlayer>
    ): Set<TaskUnit> {
        return particleSets.flatMap { particleSet ->
            particleSet.particles.map { particle ->
                TaskUnit(particle.delay) { _, _ ->
                    spawnParticle(particle, particleSet.vertical, receivers)
                }
            }
        }.toSet()
    }

    override fun convertTaskUnits(particleSets: Set<ConfiguredParticleSet>, location: ConfiguredDoubleLocation): Set<TaskUnit> {
        return particleSets.flatMap { particleSet ->
            particleSet.particles.map { particle ->
                TaskUnit(particle.delay) { _, _ ->
                    spawnParticle(particle, location)
                }
            }
        }.toSet()
    }

    override fun spawnParticle(
        particleSets: Set<ConfiguredParticleSet>,
        location: ConfiguredDoubleLocation,
        vector: ConfiguredDoubleVector,
        receivers: Set<IPlayer>
    ) {
        schedulerFactory.createScheduler().schedule(convertTaskUnits(particleSets, location, vector, receivers))
            .runSync()
    }

    override fun spawnParticle(particleSets: Set<ConfiguredParticleSet>, players: Set<IPlayer>) {
        schedulerFactory.createScheduler().schedule(convertTaskUnits(particleSets, players)).runSync()
    }

    override fun spawnParticle(particleSets: Set<ConfiguredParticleSet>, location: ConfiguredDoubleLocation) {
        schedulerFactory.createScheduler().schedule(convertTaskUnits(particleSets, location)).runSync()
    }

    override fun getReceivers(player: IGamePlayer, location: ConfiguredDoubleLocation): Set<IPlayer> {
        TODO()
    }

    protected abstract fun spawnParticle(
        particle: IConfiguredParticle,
        location: ConfiguredDoubleLocation,
        vector: ConfiguredDoubleVector,
        receivers: Set<IPlayer>
    )

    protected abstract fun spawnParticle(particle: IConfiguredParticle, vertical: Boolean, receivers: Set<IPlayer>)

    protected abstract fun spawnParticle(particle: IConfiguredParticle, location: ConfiguredDoubleLocation)
}