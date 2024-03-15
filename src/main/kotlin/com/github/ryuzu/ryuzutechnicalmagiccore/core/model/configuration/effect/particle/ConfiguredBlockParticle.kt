package com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.effect.particle

import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.ConfiguredDoubleVector

data class ConfiguredBlockParticle(
    override val id: String,
    override val count: Int,
    override val extra: Float,
    override val offset: ConfiguredDoubleVector,
    override val delay: Int,
    val block: String
) : IConfiguredParticle
