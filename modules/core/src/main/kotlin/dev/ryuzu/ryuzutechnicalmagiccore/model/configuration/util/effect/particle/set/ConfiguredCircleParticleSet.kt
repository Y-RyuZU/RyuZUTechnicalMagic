package dev.ryuzu.ryuzutechnicalmagiccore.model.configuration.util.effect.particle.set

import dev.ryuzu.ryuzutechnicalmagiccore.model.configuration.util.effect.particle.particle.IConfiguredParticle
import dev.ryuzu.ryuzutechnicalmagiccore.util.wrapper.particle.CircleParticleSetData
import dev.ryuzu.ryuzutechnicalmagiccore.util.wrapper.particle.IParticleSetData

data class ConfiguredCircleParticleSet(
    override val priority: Int = 10,
    override val delay: Int = 0,
    override val amount: Int = 1,
    override val angle: dev.ryuzu.ryuzutechnicalmagiccore.model.configuration.util.effect.particle.set.ParticleAngle = dev.ryuzu.ryuzutechnicalmagiccore.model.configuration.util.effect.particle.set.ParticleAngle.RAW,
    override val receiver: dev.ryuzu.ryuzutechnicalmagiccore.model.configuration.util.effect.particle.set.Receiver = dev.ryuzu.ryuzutechnicalmagiccore.model.configuration.util.effect.particle.set.Receiver.ALL,
    override val particles: Set<IConfiguredParticle> = emptySet(),
    val period: Long = 0,
    val speed: Int = 0,
    val acceleration: Int = 0,
    val minRadius: Double = 0.0,
    val maxRadius: Double = 0.0,
    val repeatRadiusAcceleration: Boolean = true,
    val radiusAcceleration: Double = 0.0,
) : dev.ryuzu.ryuzutechnicalmagiccore.model.configuration.util.effect.particle.set.IConfiguredParticleSet {
    override fun createParticleSetData(): IParticleSetData {
        return CircleParticleSetData(this)
    }
}
