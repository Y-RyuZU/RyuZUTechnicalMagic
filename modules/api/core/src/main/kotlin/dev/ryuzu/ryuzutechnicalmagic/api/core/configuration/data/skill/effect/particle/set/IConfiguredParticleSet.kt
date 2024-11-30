package dev.ryuzu.ryuzutechnicalmagic.api.core.configuration.data.skill.effect.particle.set

import dev.ryuzu.ryuzutechnicalmagic.api.core.configuration.data.skill.effect.particle.CircleParticleSetData
import dev.ryuzu.ryuzutechnicalmagic.api.core.configuration.skill.effect.particle.IParticleSetData
import dev.ryuzu.ryuzutechnicalmagic.api.core.configuration.data.skill.effect.particle.IConfiguredParticle
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
sealed interface IConfiguredParticleSet {
    val priority: Int
    val delay: Int
    val amount: Int
    val angle: ParticleAngle
    val receiver: Receiver
    val particles: Set<dev.ryuzu.ryuzutechnicalmagic.api.core.configuration.data.skill.effect.particle.IConfiguredParticle>

    fun createParticleSetData(): IParticleSetData

    @Serializable
    @SerialName("particle")
    data class ConfiguredParticleSet(
        override val priority: Int = 10,
        override val delay: Int = 0,
        override val amount: Int = 1,
        override val angle: ParticleAngle = ParticleAngle.RAW,
        override val receiver: Receiver = Receiver.ALL,
        override val particles: Set<dev.ryuzu.ryuzutechnicalmagic.api.core.configuration.data.skill.effect.particle.IConfiguredParticle>
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
        override val particles: Set<dev.ryuzu.ryuzutechnicalmagic.api.core.configuration.data.skill.effect.particle.IConfiguredParticle> = emptySet(),
        val period: Long = 0,
        val speed: Int = 0,
        val acceleration: Int = 0,
        val minRadius: Double = 0.0,
        val maxRadius: Double = 0.0,
        val repeatRadiusAcceleration: Boolean = true,
        val radiusAcceleration: Double = 0.0,
    ) : IConfiguredParticleSet {
        override fun createParticleSetData(): IParticleSetData {
            return dev.ryuzu.ryuzutechnicalmagic.api.core.configuration.data.skill.effect.particle.CircleParticleSetData(
                this
            )
        }
    }
}
