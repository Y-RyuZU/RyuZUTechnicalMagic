package dev.ryuzu.ryuzutechnicalmagic.api.minecraft.adapter.effect

import dev.ryuzu.ryuzutechnicalmagic.api.core.data.base.SerDoubleLocation
import dev.ryuzu.ryuzutechnicalmagic.api.core.data.base.SerDoubleVector
import dev.ryuzu.ryuzutechnicalmagic.api.core.data.effect.particle.IConfiguredParticle
import dev.ryuzu.ryuzutechnicalmagic.api.core.data.effect.sound.SerSound
import dev.ryuzu.ryuzutechnicalmagic.api.core.data.effect.sound.SerSoundSet
import dev.ryuzu.ryuzutechnicalmagic.api.core.model.entity.IPlayer

interface IEffectAdapter {
    fun spawnParticle(
        particle: IConfiguredParticle,
        location: SerDoubleLocation,
        vector: SerDoubleVector,
        receivers: Set<IPlayer>
    )

    fun spawnParticle(
        particle: IConfiguredParticle,
        location: SerDoubleLocation,
        vector: SerDoubleVector
    )

    fun playSound(soundSet: SerSoundSet, sound: SerSound, player: IPlayer)
    fun playSound(soundSet: SerSoundSet, sound: SerSound, location: SerDoubleLocation)
}