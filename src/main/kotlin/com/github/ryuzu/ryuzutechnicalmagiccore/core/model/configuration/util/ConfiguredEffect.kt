package com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.util

import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.util.display.ConfiguredDisplaySet
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.util.particle.ConfiguredParticleSet
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.util.sound.ConfiguredSoundSet

data class ConfiguredEffect(
    val displays: HashMap<String, Set<ConfiguredDisplaySet>>,
    val particles: HashMap<String, Set<ConfiguredParticleSet>>,
    val sounds: HashMap<String, Set<ConfiguredSoundSet>>,
    val items: HashMap<String, String>
)
