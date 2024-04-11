package com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.util.particle.set

import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.util.particle.particle.IConfiguredParticle
import com.github.ryuzu.ryuzutechnicalmagiccore.core.util.wrapper.particle.IParticleSetData

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
