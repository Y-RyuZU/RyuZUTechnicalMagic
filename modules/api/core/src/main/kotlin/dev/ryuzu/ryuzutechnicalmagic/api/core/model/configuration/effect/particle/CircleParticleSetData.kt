package dev.ryuzu.ryuzutechnicalmagic.api.core.model.configuration.effect.particle

import dev.ryuzu.ryuzutechnicalmagic.api.core.model.configuration.util.effect.particle.set.IConfiguredParticleSet
import org.joml.Vector3d
import kotlin.random.Random

class CircleParticleSetData(
    private val particleSet: IConfiguredParticleSet.ConfiguredCircleParticleSet
) : IParticleSetData {
    private var degree: Int = Random.nextInt(360)
    private val positiveDegreeAcceleration: Boolean = Random.nextBoolean()
    private var radius: Double = Random.nextDouble(particleSet.minRadius, particleSet.maxRadius)
    private var positiveRadiusAcceleration: Boolean = false
    private lateinit var orthonormalBasis: dev.ryuzu.ryuzutechnicalmagic.api.core.model.configuration.util.effect.particle.set.OrthonormalBasis

    fun getOrthonormalBasis (vector: Vector3d): dev.ryuzu.ryuzutechnicalmagic.api.core.model.configuration.util.effect.particle.set.OrthonormalBasis {
        if(!this::orthonormalBasis.isInitialized)
            orthonormalBasis = dev.ryuzu.ryuzutechnicalmagic.api.core.model.configuration.util.effect.particle.set.OrthonormalBasis.from(vector)
        return orthonormalBasis
    }

    fun nextDegree(): Int {
        degree += particleSet.speed * if(positiveDegreeAcceleration) 1 else -1

        return degree % 360
    }

    fun nextRadius(): Double {
        if(particleSet.repeatRadiusAcceleration) {
            radius += particleSet.radiusAcceleration * if(positiveRadiusAcceleration) 1 else -1
            if(radius >= particleSet.maxRadius) {
                radius = particleSet.maxRadius - (particleSet.minRadius - radius)
                positiveRadiusAcceleration = !positiveRadiusAcceleration
            }

            if(radius <= particleSet.minRadius) {
                radius = particleSet.minRadius + (radius - particleSet.maxRadius)
                positiveRadiusAcceleration = !positiveRadiusAcceleration
            }
        } else {
            radius += particleSet.radiusAcceleration

            if(radius >= particleSet.maxRadius)
                radius = particleSet.minRadius + (radius - particleSet.maxRadius)

            if(radius <= particleSet.minRadius)
                radius = particleSet.maxRadius - (particleSet.minRadius - radius)
        }

        return radius
    }
}