package dev.ryuzu.ryuzutechnicalmagic.core.impl.util.wrapper.particle

import dev.ryuzu.ryuzutechnicalmagic.api.core.configuration.base.ConfiguredDoubleLocation
import dev.ryuzu.ryuzutechnicalmagic.api.core.configuration.base.ConfiguredDoubleVector
import dev.ryuzu.ryuzutechnicalmagic.api.core.configuration.effect.particle.CircleParticleSetData
import dev.ryuzu.ryuzutechnicalmagic.api.core.configuration.util.effect.particle.set.IConfiguredParticleSet
import dev.ryuzu.ryuzutechnicalmagic.api.core.model.entity.IPlayer
import dev.ryuzu.ryuzutechnicalmagic.api.core.model.game.player.IGamePlayer
import dev.ryuzu.ryuzutechnicalmagic.api.core.model.scheduler.IParticleScheduler
import dev.ryuzu.ryuzutechnicalmagic.api.core.model.scheduler.TaskUnit
import dev.ryuzu.ryuzutechnicalmagic.api.minecraft.adapter.effect.IEffectAdapter
import dev.ryuzu.ryuzutechnicalmagic.api.minecraft.adapter.entity.IEntityAdapter
import dev.ryuzu.ryuzutechnicalmagic.api.core.model.effect.IParticleService
import org.joml.Vector3d
import org.koin.core.annotation.Single
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import kotlin.math.cos
import kotlin.math.sin

@Single([IParticleService::class])
class ParticleServiceImpl : IParticleService, KoinComponent {
    private val effectAdapter: IEffectAdapter by inject()
    private val entityAdapter: IEntityAdapter by inject()

    override fun convertTaskUnits(
        particleSets: Set<IConfiguredParticleSet>,
        scheduler: IParticleScheduler,
        vararg receivers: IPlayer
    ): Set<TaskUnit> =
        if (receivers.isEmpty())
            emptySet()
        else
            particleSets.flatMap { particleSet ->
                val location = entityAdapter.getDoubleLocation(receivers.first())
                processParticleSet(
                    particleSet,
                    particleSet.angle.getVector(entityAdapter.getEyeDirection(receivers.first())),
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

    override fun getReceivers(player: IGamePlayer, location: ConfiguredDoubleLocation): Set<IPlayer> {
        TODO()
    }

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
                                    val point: ConfiguredDoubleVector = ConfiguredDoubleVector(
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

                                    effectAdapter.spawnParticle(particle, point.toLocation(location.world), circleExtraVector)
                                }
                            }
                        }
                    }
                }

                else -> particleSet.particles.map { particle ->
                    TaskUnit(particleSet.delay + particle.delay) { _, _ ->
                        effectAdapter.spawnParticle(particle, location, directionVector)
                    }
                }
            }
        }.toSet()
}