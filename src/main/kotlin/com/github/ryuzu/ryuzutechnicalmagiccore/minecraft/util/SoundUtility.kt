package com.github.ryuzu.ryuzutechnicalmagiccore.minecraft.util

import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.effect.sound.ConfiguredSoundSet
import com.github.ryuzu.ryuzutechnicalmagiccore.core.util.scheduler.TaskUnit
import org.bukkit.SoundCategory
import org.bukkit.entity.Player
import org.koin.core.annotation.Single

@Single
class SoundUtility {

    fun convertTaskUnits(soundSet: ConfiguredSoundSet, vararg players: Player): List<TaskUnit> {
        return soundSet.sounds.map { sound ->
            val category = SoundCategory.valueOf(soundSet.category)
            TaskUnit(sound.delay) { _, _ ->
                players
                    .forEach { player ->
                        if (soundSet.listenerOnly)
                            player.playSound(player.location, sound.id, category, sound.volume, sound.pitch)
                        else
                            player.location.world.playSound(player.location, sound.id, category, sound.volume, sound.pitch)
                    }
            }
        }
    }
}