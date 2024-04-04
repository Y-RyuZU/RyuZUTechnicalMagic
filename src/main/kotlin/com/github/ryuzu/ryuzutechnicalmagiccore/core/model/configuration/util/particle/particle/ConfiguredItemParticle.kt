package com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.util.particle.particle

import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.base.ConfiguredDoubleVector

data class ConfiguredItemParticle(
    override val id: String,
    override val count: Int = 1,
    override val extra: Double = 0.0,
    override val offset: ConfiguredDoubleVector = ConfiguredDoubleVector(),
    override val delay: Long = 0,
    val item: String,
    val customModel: Int,
    val enchantmentAura: Boolean = false
) : IConfiguredParticle
