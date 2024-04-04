package com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.util

import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.util.display.ConfiguredDisplaySet
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.util.particle.set.IConfiguredParticleSet
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.util.sound.ConfiguredSoundSet

data class ConfiguredEffect(
    val displays: Map<String, Set<ConfiguredDisplaySet>> = emptyMap(),
    val particles: Map<String, Set<IConfiguredParticleSet>> = emptyMap(),
    val sounds: Map<String, Set<ConfiguredSoundSet>> = emptyMap(),
)
