package com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.util.particle.set

import com.fasterxml.jackson.annotation.JsonSubTypes
import com.fasterxml.jackson.annotation.JsonTypeInfo
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.util.particle.particle.IConfiguredParticle
import com.github.ryuzu.ryuzutechnicalmagiccore.core.util.wrapper.particle.IParticleSetData

@JsonTypeInfo(
    use = JsonTypeInfo.Id.NAME,
    include = JsonTypeInfo.As.PROPERTY,
    property = "Type",
    defaultImpl = ConfiguredParticleSet::class
)
@JsonSubTypes(
    JsonSubTypes.Type(value = ConfiguredCircleParticleSet::class, name = "CIRCLE"),
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
