package com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.util.effect.particle.set

import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.util.effect.particle.particle.IConfiguredParticle
import com.github.ryuzu.ryuzutechnicalmagiccore.core.util.wrapper.particle.CircleParticleSetData
import com.github.ryuzu.ryuzutechnicalmagiccore.core.util.wrapper.particle.IParticleSetData

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
