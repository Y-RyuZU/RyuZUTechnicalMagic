package dev.ryuzu.ryuzutechnicalmagic.core.impl.util.wrapper.particle

import dev.ryuzu.ryuzutechnicalmagic.api.core.model.configuration.base.ConfiguredDoubleLocation
import dev.ryuzu.ryuzutechnicalmagic.api.core.model.configuration.base.ConfiguredDoubleVector
import dev.ryuzu.ryuzutechnicalmagic.api.core.model.configuration.effect.particle.CircleParticleSetData
import dev.ryuzu.ryuzutechnicalmagic.api.core.model.configuration.util.effect.particle.particle.IConfiguredParticle
import dev.ryuzu.ryuzutechnicalmagic.api.core.model.configuration.util.effect.particle.set.IConfiguredParticleSet
import dev.ryuzu.ryuzutechnicalmagic.api.core.model.entity.IPlayer
import dev.ryuzu.ryuzutechnicalmagic.api.core.model.game.player.IGamePlayer
import dev.ryuzu.ryuzutechnicalmagic.api.core.model.scheduler.IParticleScheduler
import dev.ryuzu.ryuzutechnicalmagic.api.core.model.scheduler.TaskUnit
import dev.ryuzu.ryuzutechnicalmagic.api.minecraft.adapter.location.ILocationService
import dev.ryuzu.ryuzutechnicalmagic.api.minecraft.adapter.particle.IParticleService
import dev.ryuzu.ryuzutechnicalmagic.core.impl.model.scheduler.SimpleSchedulerFactory
import org.joml.Vector3d
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import kotlin.math.cos
import kotlin.math.sin

abstract class AbstractParticleService : IParticleService, KoinComponent {
    private val schedulerFactory: SimpleSchedulerFactory by inject()
    private val locationService: ILocationService by inject()

    private fun processParticleSet(
        particleSet: IConfiguredParticleSet,
        vector: ConfiguredDoubleVector,
        location: ConfiguredDoubleLocation,
        scheduler: IParticleScheduler
    ): Set<TaskUnit> =
        (0 until particleSet.amount).flatMap { index ->
            val directionVector = particleSet.angle.getVector(vector)
            when (particleSet) {
                is IConfiguredParticleSet.ConfiguredCircleParticleSet -> {
                    val data = scheduler.getData(particleSet, index) as CircleParticleSetData
                    val orthonormalBasis = data.getOrthonormalBasis(directionVector)
                    (0 until particleSet.period).flatMap { count ->
                        particleSet.particles.map { particle ->
                            TaskUnit(particleSet.delay + particle.delay + count) { _, _ ->
                                for (i in 0 until particleSet.acceleration) {
                                    val radian = Math.toRadians(data.nextDegree().toDouble())
                                    val radius = data.nextRadius()
                                    val point = ConfiguredDoubleVector(
                                        Vector3d(location.vector)
                                            .add(Vector3d(orthonormalBasis.u).mul(cos(radian) * radius))
                                            .add(Vector3d(orthonormalBasis.w).mul(sin(radian) * radius))
                                    )

                                    val circleExtraVector = ConfiguredDoubleVector(
                                        if (particle.count == 0)
                                            Vector3d(point).sub(location.vector).normalize()
                                        else
                                            orthonormalBasis.u
                                    )

                                    spawnParticle(particle, point.toLocation(location.world), circleExtraVector)
                                }
                            }
                        }
                    }
                }

                else -> particleSet.particles.map { particle ->
                    TaskUnit(particleSet.delay + particle.delay) { _, _ ->
                        spawnParticle(particle, location, directionVector)
                    }
                }
            }
        }.toSet()

    override fun convertTaskUnits(
        particleSets: Set<IConfiguredParticleSet>,
        scheduler: IParticleScheduler,
        receivers: Set<IPlayer>
    ): Set<TaskUnit> =
        if (receivers.isEmpty())
            emptySet()
        else
            particleSets.flatMap { particleSet ->
                val location = locationService.getDoubleLocation(receivers.first())
                processParticleSet(
                    particleSet,
                    particleSet.angle.getVector(locationService.getEyeDirection(receivers.first())),
                    location,
                    scheduler
                )
            }.toSet()


    override fun convertTaskUnits(
        particleSets: Set<IConfiguredParticleSet>,
        location: ConfiguredDoubleLocation,
        vector: ConfiguredDoubleVector,
        scheduler: IParticleScheduler
    ): Set<TaskUnit> =
        particleSets.flatMap { particleSet ->
            processParticleSet(particleSet, particleSet.angle.getVector(vector), location, scheduler)
        }.toSet()

    override fun spawnParticle(
        particleSets: Set<IConfiguredParticleSet>,
        location: ConfiguredDoubleLocation,
        vector: ConfiguredDoubleVector,
    ) {
        schedulerFactory.createParticleScheduler()
            .apply { schedule(convertTaskUnits(particleSets, location, vector, this)) }.runSync()
    }

    override fun spawnParticle(particleSets: Set<IConfiguredParticleSet>, players: Set<IPlayer>) {
        schedulerFactory.createParticleScheduler().apply { schedule(convertTaskUnits(particleSets, this, players)) }
            .runSync()
    }

    override fun getReceivers(player: IGamePlayer, location: ConfiguredDoubleLocation): Set<IPlayer> {
        TODO()
    }

//    protected abstract fun spawnParticle(
//        particle: IConfiguredParticle,
//        location: ConfiguredDoubleLocation,
//        vector: ConfiguredDoubleVector,
//        receivers: Set<IPlayer>
//    )

    protected abstract fun spawnParticle(
        particle: IConfiguredParticle,
        location: ConfiguredDoubleLocation,
        vector: ConfiguredDoubleVector
    )
}