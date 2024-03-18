package com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.skill

import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.effect.display.ConfiguredDisplaySet
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.effect.particle.ConfiguredParticleSet
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.effect.sound.ConfiguredSoundSet
import com.github.ryuzu.ryuzutechnicalmagiccore.core.util.TypedMap

data class ConfiguredSkillParams (
    val id: String,
    val soundSets: Map<String, ConfiguredSoundSet>,
    val particleSets: Map<String, ConfiguredParticleSet>,
    val displaySets: Map<String, ConfiguredDisplaySet>,
    val performance: TypedMap
)