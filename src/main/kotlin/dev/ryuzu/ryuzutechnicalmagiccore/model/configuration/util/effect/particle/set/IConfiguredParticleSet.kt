package dev.ryuzu.ryuzutechnicalmagiccore.model.configuration.util.effect.particle.set

import com.fasterxml.jackson.annotation.JsonSubTypes
import com.fasterxml.jackson.annotation.JsonTypeInfo
import dev.ryuzu.ryuzutechnicalmagiccore.model.configuration.util.effect.particle.particle.IConfiguredParticle
import dev.ryuzu.ryuzutechnicalmagiccore.util.wrapper.particle.IParticleSetData

@JsonTypeInfo(
    use = JsonTypeInfo.Id.NAME,
    include = JsonTypeInfo.As.PROPERTY,
    property = "Type",
    defaultImpl = ConfiguredParticleSet::class
)
@JsonSubTypes(
    JsonSubTypes.Type(value = dev.ryuzu.ryuzutechnicalmagiccore.model.configuration.util.effect.particle.set.ConfiguredCircleParticleSet::class, name = "CIRCLE"),
)
interface IConfiguredParticleSet {
    val priority: Int
    val delay: Int
    val amount: Int
    val angle: ParticleAngle
    val receiver: Receiver
    val particles: Set<IConfiguredParticle>

    fun createParticleSetData(): IParticleSetData
}
