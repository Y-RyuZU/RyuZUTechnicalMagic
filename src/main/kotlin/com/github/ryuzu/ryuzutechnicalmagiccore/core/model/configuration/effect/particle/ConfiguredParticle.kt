package com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.effect.particle

import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.base.ConfiguredDoubleVector

data class ConfiguredParticle(
    override val id: String,
    override val count: Int,
    override val extra: Double,
    override val offset: ConfiguredDoubleVector,
    override val delay: Long
) : IConfiguredParticle
