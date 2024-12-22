package dev.ryuzu.ryuzutechnicalmagic.core.impl.util.wrapper.particle

import dev.ryuzu.ryuzutechnicalmagic.api.core.data.base.SerDoubleLocation
import dev.ryuzu.ryuzutechnicalmagic.api.core.data.base.SerDoubleVector
import dev.ryuzu.ryuzutechnicalmagic.api.core.data.effect.particle.set.CircleParticleSetData
import dev.ryuzu.ryuzutechnicalmagic.api.core.data.effect.particle.IConfiguredParticle
import dev.ryuzu.ryuzutechnicalmagic.api.core.data.effect.particle.set.ConfiguredCircleParticleSet
import dev.ryuzu.ryuzutechnicalmagic.api.core.data.effect.particle.set.IConfiguredParticleSet
import dev.ryuzu.ryuzutechnicalmagic.api.core.data.effect.particle.set.OrthonormalBasis
import dev.ryuzu.ryuzutechnicalmagic.api.core.model.effect.IParticleService
import dev.ryuzu.ryuzutechnicalmagic.api.core.model.entity.IPlayer
import dev.ryuzu.ryuzutechnicalmagic.api.core.model.game.player.IGamePlayer
import dev.ryuzu.ryuzutechnicalmagic.api.core.model.scheduler.IParticleScheduler
import dev.ryuzu.ryuzutechnicalmagic.api.core.model.scheduler.TaskUnit
import dev.ryuzu.ryuzutechnicalmagic.api.minecraft.adapter.effect.IEffectAdapter
import dev.ryuzu.ryuzutechnicalmagic.api.minecraft.adapter.entity.IEntityAdapter
import org.koin.core.annotation.Single
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

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
        location: SerDoubleLocation,
        vector: SerDoubleVector,
        scheduler: IParticleScheduler
    ): Set<TaskUnit> =
        particleSets.flatMap { particleSet ->
            processParticleSet(particleSet, particleSet.angle.getVector(vector), location, scheduler)
        }.toSet()

    override fun getReceivers(player: IGamePlayer, location: SerDoubleLocation): Set<IPlayer> {
        TODO()
    }

    private fun processParticleSet(
        particleSet: IConfiguredParticleSet,
        vector: SerDoubleVector,
        location: SerDoubleLocation,
        scheduler: IParticleScheduler
    ): Set<TaskUnit> {
        return (0 until particleSet.amount).flatMap { index ->
            val directionVector = particleSet.angle.getVector(vector)

            when(particleSet) {
                is ConfiguredCircleParticleSet -> {
                    processCircleParticleSet(particleSet, index, directionVector, location, scheduler)
                }
                else -> {
                    processDefaultParticleSet(particleSet, location, directionVector)
                }
            }
        }.toSet()
    }

    private fun processCircleParticleSet(
        particleSet: ConfiguredCircleParticleSet,
        index: Int,
        directionVector: SerDoubleVector,
        location: SerDoubleLocation,
        scheduler: IParticleScheduler
    ): List<TaskUnit> {
        val data = scheduler.getData(particleSet, index) as CircleParticleSetData
        val orthonormalBasis = data.getOrthonormalBasis(directionVector)

        return (0 until particleSet.period).flatMap { count ->
            particleSet.particles.map { particle ->
                createCircleTaskUnit(particleSet, particle, count, orthonormalBasis, location, data)
            }
        }
    }

    private fun createCircleTaskUnit(
        particleSet: ConfiguredCircleParticleSet,
        particle: IConfiguredParticle,
        count: Long,
        orthonormalBasis: OrthonormalBasis,
        location: SerDoubleLocation,
        data: CircleParticleSetData
    ): TaskUnit {
        return TaskUnit(particleSet.delay + particle.delay + count) { _, _ ->
            repeat(particleSet.acceleration) {
                val radian = Math.toRadians(data.nextDegree().toDouble())
                val radius = data.nextRadius()
                val point = location.vector.calculateCirclePoint(orthonormalBasis, radian, radius)
                val extraVector = location.vector.calculateCircleExtraVector(particle, point, orthonormalBasis)
                effectAdapter.spawnParticle(particle, point.toLocation(location.world), extraVector)
            }
        }
    }

    private fun processDefaultParticleSet(
        particleSet: IConfiguredParticleSet,
        location: SerDoubleLocation,
        directionVector: SerDoubleVector
    ): List<TaskUnit> {
        return particleSet.particles.map { particle ->
            TaskUnit(particleSet.delay + particle.delay) { _, _ ->
                effectAdapter.spawnParticle(particle, location, directionVector)
            }
        }
    }
}