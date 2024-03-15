package com.github.ryuzu.ryuzutechnicalmagiccore.core.model.skill

import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.effect.display.ConfiguredDisplaySet
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.effect.particle.ConfiguredParticleSet
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.effect.sound.ConfiguredSoundSet
import com.github.ryuzu.ryuzutechnicalmagiccore.core.util.TypedMap

interface ISkill {
    val id: String
    val soundSets: HashMap<String, ConfiguredSoundSet>
    val particleSets: HashMap<String, ConfiguredParticleSet>
    val displaySets: HashMap<String, ConfiguredDisplaySet>
    val performance: TypedMap

    fun onRightClick() = Unit
    fun onLeftClick() = Unit
    fun onShiftChange() = Unit
    fun onJump() = Unit
    fun onSprint() = Unit
    fun onDamage() = Unit
    fun onKill() = Unit
    fun onDeath() = Unit
}