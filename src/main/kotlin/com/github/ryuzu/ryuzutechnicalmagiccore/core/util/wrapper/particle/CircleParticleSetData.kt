package com.github.ryuzu.ryuzutechnicalmagiccore.core.util.wrapper.particle

import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.base.ConfiguredDoubleVector
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.util.particle.set.ConfiguredCircleParticleSet
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.util.particle.set.OrthonormalBasis
import org.joml.Vector3d
import kotlin.random.Random

class CircleParticleSetData(
    private val particleSet: ConfiguredCircleParticleSet
) : IParticleSetData {
    private var degree: Int = Random.nextInt(360)
    private var radius: Double = Random.nextDouble(particleSet.minRadius, particleSet.maxRadius)
    private var positiveRadiusAcceleration: Boolean = false
    private lateinit var orthonormalBasis: OrthonormalBasis

    fun getOrthonormalBasis (vector: Vector3d): OrthonormalBasis {
        if(!this::orthonormalBasis.isInitialized)
            orthonormalBasis = OrthonormalBasis.from(vector)
        return orthonormalBasis
    }

    fun nextDegree(): Int {
        degree += particleSet.speed
        if(degree >= 360)
            degree -= 360

        return degree
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