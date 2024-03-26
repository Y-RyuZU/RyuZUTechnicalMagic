package com.github.ryuzu.ryuzutechnicalmagiccore.minecraft.implementation.util.wrapper.sound

import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.util.sound.ConfiguredSound
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.util.sound.ConfiguredSoundSet
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.player.IPlayer
import com.github.ryuzu.ryuzutechnicalmagiccore.core.util.wrapper.sound.AbstractSoundService
import com.github.ryuzu.ryuzutechnicalmagiccore.minecraft.util.PlayerUtility.Companion.toPlayer
import org.bukkit.SoundCategory
import org.koin.core.annotation.Single
import java.util.*

@Single
class SoundServiceImpl : AbstractSoundService() {
    override fun playSound(soundSet: ConfiguredSoundSet, sound: ConfiguredSound, player: IPlayer) {
        val category = SoundCategory.valueOf(soundSet.category)
        val player = player.toPlayer()
        if (soundSet.listenerOnly)
            player.playSound(player.location, sound.id, category, sound.volume, sound.pitch)
        else
            player.location.world.playSound(player.location, sound.id, category, sound.volume, sound.pitch)
    }
}