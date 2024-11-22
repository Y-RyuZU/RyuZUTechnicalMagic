package dev.ryuzu.ryuzutechnicalmagiccore.model.configuration.util.effect.particle.particle

import dev.ryuzu.ryuzutechnicalmagiccore.model.configuration.base.ConfiguredDoubleVector

data class ConfiguredBlockParticle(
    override val id: String,
    override val count: Int = 1,
    override val extra: Double = 0.0,
    override val offset: ConfiguredDoubleVector = ConfiguredDoubleVector(),
    override val delay: Long = 0,
    val block: String
) : IConfiguredParticle