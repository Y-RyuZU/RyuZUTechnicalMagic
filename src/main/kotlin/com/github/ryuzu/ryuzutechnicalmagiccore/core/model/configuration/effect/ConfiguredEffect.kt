package com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.effect

import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.effect.display.ConfiguredDisplaySet
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.effect.particle.ConfiguredParticleSet
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.effect.sound.ConfiguredSoundSet

data class ConfiguredEffect(
    val displays: HashMap<String, ConfiguredDisplaySet>,
    val particles: HashMap<String, ConfiguredParticleSet>,
    val sounds: HashMap<String, ConfiguredSoundSet>
)
