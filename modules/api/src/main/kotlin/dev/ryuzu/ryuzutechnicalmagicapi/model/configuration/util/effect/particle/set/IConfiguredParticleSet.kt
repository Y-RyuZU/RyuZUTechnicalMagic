package dev.ryuzu.ryuzutechnicalmagicapi.model.configuration.util.effect.particle.set

import dev.ryuzu.ryuzutechnicalmagicapi.model.configuration.util.effect.particle.particle.IConfiguredParticle
import dev.ryuzu.ryuzutechnicalmagicapi.util.wrapper.particle.CircleParticleSetData
import dev.ryuzu.ryuzutechnicalmagicapi.util.wrapper.particle.IParticleSetData
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
sealed interface IConfiguredParticleSet {
    val priority: Int
    val delay: Int
    val amount: Int
    val angle: ParticleAngle
    val receiver: Receiver
    val particles: Set<IConfiguredParticle>

    fun createParticleSetData(): IParticleSetData

    @Serializable
    @SerialName("particle")
    data class ConfiguredParticleSet(
        override val priority: Int = 10,
        override val delay: Int = 0,
        override val amount: Int = 1,
        override val angle: ParticleAngle = ParticleAngle.RAW,
        override val receiver: Receiver = Receiver.ALL,
        override val particles: Set<IConfiguredParticle>
    ) : IConfiguredParticleSet {
        override fun createParticleSetData(): IParticleSetData {
            throw NotImplementedError("Not yet implemented")
        }
    }


    @Serializable
    @SerialName("circle")
    data class ConfiguredCircleParticleSet(
        override val priority: Int = 10,
        override val delay: Int = 0,
        override val amount: Int = 1,
        override val angle: ParticleAngle = ParticleAngle.RAW,
        override val receiver: Receiver = Receiver.ALL,
        override val particles: Set<IConfiguredParticle> = emptySet(),
        val period: Long = 0,
        val speed: Int = 0,
        val acceleration: Int = 0,
        val minRadius: Double = 0.0,
        val maxRadius: Double = 0.0,
        val repeatRadiusAcceleration: Boolean = true,
        val radiusAcceleration: Double = 0.0,
    ) : IConfiguredParticleSet {
        override fun createParticleSetData(): IParticleSetData {
            return CircleParticleSetData(this)
        }
    }
}