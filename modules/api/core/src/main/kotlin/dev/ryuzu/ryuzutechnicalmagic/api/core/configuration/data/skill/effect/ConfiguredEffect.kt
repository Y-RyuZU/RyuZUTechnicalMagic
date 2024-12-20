package dev.ryuzu.ryuzutechnicalmagic.api.core.configuration.data.skill.effect

import dev.ryuzu.ryuzutechnicalmagic.api.core.model.configuration.util.effect.display.ConfiguredDisplaySet
import dev.ryuzu.ryuzutechnicalmagic.api.core.configuration.skill.effect.particle.set.IConfiguredParticleSet
import dev.ryuzu.ryuzutechnicalmagic.api.core.model.configuration.util.effect.sound.ConfiguredSoundSet

data class ConfiguredEffect(
    val displays: Map<String, Set<ConfiguredDisplaySet>> = emptyMap(),
    val particles: Map<String, Set<IConfiguredParticleSet>> = emptyMap(),
    val sounds: Map<String, Set<ConfiguredSoundSet>> = emptyMap(),
)
