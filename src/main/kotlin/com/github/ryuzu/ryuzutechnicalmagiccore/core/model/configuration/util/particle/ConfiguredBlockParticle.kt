package com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.util.particle

import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.base.ConfiguredDoubleVector

data class ConfiguredBlockParticle(
    override val id: String,
    override val count: Int = 1,
    override val extra: Double = 0.0,
    override val offset: ConfiguredDoubleVector = ConfiguredDoubleVector(),
    override val delay: Long = 0,
    val block: String
) : IConfiguredParticle
