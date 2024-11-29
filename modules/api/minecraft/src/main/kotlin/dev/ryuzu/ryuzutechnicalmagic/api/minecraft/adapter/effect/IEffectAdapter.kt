package dev.ryuzu.ryuzutechnicalmagic.api.minecraft.adapter.effect

import dev.ryuzu.ryuzutechnicalmagic.api.core.configuration.base.ConfiguredDoubleLocation
import dev.ryuzu.ryuzutechnicalmagic.api.core.configuration.base.ConfiguredDoubleVector
import dev.ryuzu.ryuzutechnicalmagic.api.core.configuration.util.effect.particle.particle.IConfiguredParticle
import dev.ryuzu.ryuzutechnicalmagic.api.core.configuration.util.effect.sound.ConfiguredSound
import dev.ryuzu.ryuzutechnicalmagic.api.core.configuration.util.effect.sound.ConfiguredSoundSet
import dev.ryuzu.ryuzutechnicalmagic.api.core.model.entity.IPlayer

interface IEffectAdapter {
    fun spawnParticle(
        particle: IConfiguredParticle,
        location: ConfiguredDoubleLocation,
        vector: ConfiguredDoubleVector,
        receivers: Set<IPlayer>
    )

    fun spawnParticle(
        particle: IConfiguredParticle,
        location: ConfiguredDoubleLocation,
        vector: ConfiguredDoubleVector
    )

    fun playSound(soundSet: ConfiguredSoundSet, sound: ConfiguredSound, player: IPlayer)
    fun playSound(soundSet: ConfiguredSoundSet, sound: ConfiguredSound, location: ConfiguredDoubleLocation)
}