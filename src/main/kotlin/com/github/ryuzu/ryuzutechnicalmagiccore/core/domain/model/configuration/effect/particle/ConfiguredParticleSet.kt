package com.github.ryuzu.ryuzutechnicalmagiccore.core.domain.model.configuration.effect.particle

import com.github.ryuzu.ryuzutechnicalmagiccore.core.domain.model.configuration.effect.sound.ConfiguredSound

data class ConfiguredParticleSet(
    val name: String,
    val priority: Int,
    val amount: Int,
    val sounds: List<IConfiguredParticle>
)
