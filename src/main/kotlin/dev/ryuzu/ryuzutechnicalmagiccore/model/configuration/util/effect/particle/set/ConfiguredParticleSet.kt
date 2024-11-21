package dev.ryuzu.ryuzutechnicalmagiccore.model.configuration.util.effect.particle.set

import dev.ryuzu.ryuzutechnicalmagiccore.model.configuration.util.effect.particle.particle.IConfiguredParticle
import dev.ryuzu.ryuzutechnicalmagiccore.util.wrapper.particle.IParticleSetData

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
