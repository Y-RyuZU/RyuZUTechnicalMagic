package com.github.ryuzu.ryuzutechnicalmagiccore.core.model.skill.weapon

import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.effect.display.ConfiguredDisplaySet
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.effect.particle.ConfiguredParticleSet
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.effect.sound.ConfiguredSoundSet
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.skill.ISkill
import com.github.ryuzu.ryuzutechnicalmagiccore.core.util.TypedMap

class TestMagic : ISkill {
    override val id: String
        get() = TODO("Not yet implemented")
    override val soundSets: HashMap<String, ConfiguredSoundSet>
        get() = TODO("Not yet implemented")
    override val particleSets: HashMap<String, ConfiguredParticleSet>
        get() = TODO("Not yet implemented")
    override val displaySets: HashMap<String, ConfiguredDisplaySet>
        get() = TODO("Not yet implemented")
    override val performance: TypedMap
        get() = TODO("Not yet implemented")
}