package dev.ryuzu.ryuzutechnicalmagicapi.model.configuration.util.effect

import dev.ryuzu.ryuzutechnicalmagicapi.model.configuration.util.effect.display.ConfiguredDisplaySet
import dev.ryuzu.ryuzutechnicalmagicapi.model.configuration.util.effect.particle.set.IConfiguredParticleSet
import dev.ryuzu.ryuzutechnicalmagicapi.model.configuration.util.effect.sound.ConfiguredSoundSet

data class ConfiguredEffect(
    val displays: Map<String, Set<ConfiguredDisplaySet>> = emptyMap(),
    val particles: Map<String, Set<IConfiguredParticleSet>> = emptyMap(),
    val sounds: Map<String, Set<ConfiguredSoundSet>> = emptyMap(),
)
