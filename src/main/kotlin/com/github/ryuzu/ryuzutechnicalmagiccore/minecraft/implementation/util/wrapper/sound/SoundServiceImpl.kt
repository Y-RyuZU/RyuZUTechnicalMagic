package com.github.ryuzu.ryuzutechnicalmagiccore.minecraft.implementation.util.wrapper.sound

import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.base.ConfiguredDoubleLocation
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.util.effect.sound.ConfiguredSound
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.util.effect.sound.ConfiguredSoundSet
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.entity.IPlayer
import com.github.ryuzu.ryuzutechnicalmagiccore.core.util.wrapper.sound.AbstractSoundService
import com.github.ryuzu.ryuzutechnicalmagiccore.core.util.wrapper.sound.ISoundService
import com.github.ryuzu.ryuzutechnicalmagiccore.minecraft.util.ConfiguredUtility.Companion.toLocation
import com.github.ryuzu.ryuzutechnicalmagiccore.minecraft.util.EntityUtility.Companion.toPlayer
import org.bukkit.Sound
import org.bukkit.SoundCategory
import org.koin.core.annotation.Single

@Single([ISoundService::class])
class SoundServiceImpl : AbstractSoundService() {
    override fun playSound(soundSet: ConfiguredSoundSet, sound: ConfiguredSound, player: IPlayer) {
        val category = SoundCategory.valueOf(soundSet.category.uppercase())
        val player = player.toPlayer()

        try {
            val soundId = Sound.valueOf(sound.id.uppercase())
            if (soundSet.listenerOnly)
                player.playSound(player.location, soundId, category, sound.volume, sound.pitch)
            else
                player.location.world.playSound(player.location, soundId, category, sound.volume, sound.pitch)
        } catch (e: IllegalArgumentException) {
            if (soundSet.listenerOnly)
                player.playSound(player.location, sound.id, category, sound.volume, sound.pitch)
            else
                player.location.world.playSound(player.location, sound.id, category, sound.volume, sound.pitch)
        }
    }

    override fun playSound(soundSet: ConfiguredSoundSet, sound: ConfiguredSound, location: ConfiguredDoubleLocation) {
        val category = SoundCategory.valueOf(soundSet.category.uppercase())
        val world = location.toLocation().world

        try {
            val soundId = Sound.valueOf(sound.id.uppercase())
            world.playSound(location.toLocation(), soundId, category, sound.volume, sound.pitch)
        } catch (e: IllegalArgumentException) {
            world.playSound(location.toLocation(), sound.id, category, sound.volume, sound.pitch)
        }
    }
}