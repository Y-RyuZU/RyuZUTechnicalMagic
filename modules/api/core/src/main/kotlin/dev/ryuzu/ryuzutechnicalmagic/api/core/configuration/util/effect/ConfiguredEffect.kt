package dev.ryuzu.ryuzutechnicalmagic.api.core.configuration.util.effect

import dev.ryuzu.ryuzutechnicalmagic.api.core.model.configuration.util.effect.display.ConfiguredDisplaySet
import dev.ryuzu.ryuzutechnicalmagic.api.core.configuration.util.effect.particle.set.IConfiguredParticleSet
import dev.ryuzu.ryuzutechnicalmagic.api.core.model.configuration.util.effect.sound.ConfiguredSoundSet

data class ConfiguredEffect(
    val displays: Map<String, Set<ConfiguredDisplaySet>> = emptyMap(),
    val particles: Map<String, Set<dev.ryuzu.ryuzutechnicalmagic.api.core.configuration.util.effect.particle.set.IConfiguredParticleSet>> = emptyMap(),
    val sounds: Map<String, Set<ConfiguredSoundSet>> = emptyMap(),
)
