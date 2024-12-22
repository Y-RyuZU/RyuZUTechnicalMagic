package dev.ryuzu.ryuzutechnicalmagic.api.core.data.effect

import dev.ryuzu.ryuzutechnicalmagic.api.core.data.effect.display.SerDisplaySet
import dev.ryuzu.ryuzutechnicalmagic.api.core.data.effect.particle.set.IConfiguredParticleSet
import dev.ryuzu.ryuzutechnicalmagic.api.core.data.effect.sound.SerSoundSet
import kotlinx.serialization.Serializable

@Serializable
data class SerEffect(
    val displays: Map<String, Set<SerDisplaySet>> = emptyMap(),
    val particles: Map<String, Set<IConfiguredParticleSet>> = emptyMap(),
    val sounds: Map<String, Set<SerSoundSet>> = emptyMap(),
)
