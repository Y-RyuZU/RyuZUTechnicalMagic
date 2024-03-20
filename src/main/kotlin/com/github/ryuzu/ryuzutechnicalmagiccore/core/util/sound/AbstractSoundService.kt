package com.github.ryuzu.ryuzutechnicalmagiccore.core.util.sound

import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.util.sound.ConfiguredSound
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.util.sound.ConfiguredSoundSet
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.game.player.IGamePlayer
import com.github.ryuzu.ryuzutechnicalmagiccore.core.util.scheduler.TaskUnit
import com.github.ryuzu.ryuzutechnicalmagiccore.minecraft.implementation.util.scheduler.SimpleSchedulerFactory

import org.koin.core.component.inject
import java.util.*

abstract class AbstractSoundService : ISoundService {
    private val schedulerFactory: SimpleSchedulerFactory by inject()

    override fun convertTaskUnits(soundSets: Set<ConfiguredSoundSet>, players: Set<UUID>): Set<TaskUnit> {
        return soundSets.flatMap { soundSet ->
            soundSet.sounds.map { sound ->
                TaskUnit(sound.delay) { _, _ ->
                    players
                        .forEach {
                            if (soundSet.listenerOnly)
                                playSound(soundSet, sound, it)
                            else
                                playSound(soundSet, sound, it)
                        }
                }
            }
        }.toSet()
    }

    override fun playSound(soundSets: Set<ConfiguredSoundSet>, players: Set<UUID>) {
        schedulerFactory.createScheduler().schedule(convertTaskUnits(soundSets, players)).runSync()
    }

    override fun playSound(soundSets: Set<ConfiguredSoundSet>, vararg players: UUID) {
        schedulerFactory.createScheduler().schedule(convertTaskUnits(soundSets, players.toSet())).runSync()
    }

    protected abstract fun playSound(soundSet: ConfiguredSoundSet, sound: ConfiguredSound, player: UUID)
}