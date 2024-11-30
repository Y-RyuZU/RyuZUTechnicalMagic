package dev.ryuzu.ryuzutechnicalmagic.api.minecraft.adapter.effect

import dev.ryuzu.ryuzutechnicalmagic.api.core.configuration.data.base.ConfiguredDoubleLocation
import dev.ryuzu.ryuzutechnicalmagic.api.core.configuration.data.base.ConfiguredDoubleVector
import dev.ryuzu.ryuzutechnicalmagic.api.core.configuration.data.skill.effect.particle.IConfiguredParticle
import dev.ryuzu.ryuzutechnicalmagic.api.core.configuration.skill.effect.sound.ConfiguredSound
import dev.ryuzu.ryuzutechnicalmagic.api.core.configuration.skill.effect.sound.ConfiguredSoundSet
import dev.ryuzu.ryuzutechnicalmagic.api.core.model.entity.IPlayer

interface IEffectAdapter {
    fun spawnParticle(
        particle: dev.ryuzu.ryuzutechnicalmagic.api.core.configuration.data.skill.effect.particle.IConfiguredParticle,
        location: ConfiguredDoubleLocation,
        vector: ConfiguredDoubleVector,
        receivers: Set<IPlayer>
    )

    fun spawnParticle(
        particle: dev.ryuzu.ryuzutechnicalmagic.api.core.configuration.data.skill.effect.particle.IConfiguredParticle,
        location: ConfiguredDoubleLocation,
        vector: ConfiguredDoubleVector
    )

    fun playSound(soundSet: ConfiguredSoundSet, sound: ConfiguredSound, player: IPlayer)
    fun playSound(soundSet: ConfiguredSoundSet, sound: ConfiguredSound, location: ConfiguredDoubleLocation)
}