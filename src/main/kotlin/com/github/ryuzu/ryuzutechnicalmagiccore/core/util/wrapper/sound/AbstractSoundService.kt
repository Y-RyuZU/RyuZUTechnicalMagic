package com.github.ryuzu.ryuzutechnicalmagiccore.core.util.wrapper.sound

import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.base.ConfiguredDoubleLocation
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.util.sound.ConfiguredSound
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.util.sound.ConfiguredSoundSet
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.entity.IPlayer
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.scheduler.TaskUnit
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.scheduler.SimpleSchedulerFactory

import org.koin.core.component.inject

abstract class AbstractSoundService : ISoundService {
    private val schedulerFactory: SimpleSchedulerFactory by inject()

    override fun convertTaskUnits(soundSets: Set<ConfiguredSoundSet>, players: Set<IPlayer>): Set<TaskUnit> {
        return soundSets.flatMap { soundSet ->
            soundSet.sounds.map { sound ->
                TaskUnit(sound.delay) { _, _ ->
                    players
                        .forEach {
                            playSound(soundSet, sound, it)
                        }
                }
            }
        }.toSet()
    }

    override fun convertTaskUnits(soundSets: Set<ConfiguredSoundSet>, location: ConfiguredDoubleLocation): Set<TaskUnit> {
        return soundSets.flatMap { soundSet ->
            soundSet.sounds.map { sound ->
                TaskUnit(sound.delay) { _, _ ->
                    playSound(soundSet, sound, location)
                }
            }
        }.toSet()
    }

    override fun playSound(soundSets: Set<ConfiguredSoundSet>, players: Set<IPlayer>) {
        schedulerFactory.createScheduler().schedule(convertTaskUnits(soundSets, players)).runSync()
    }

    override fun playSound(soundSets: Set<ConfiguredSoundSet>, location: ConfiguredDoubleLocation) {
        schedulerFactory.createScheduler().schedule(convertTaskUnits(soundSets, location)).runSync()
    }

    protected abstract fun playSound(soundSet: ConfiguredSoundSet, sound: ConfiguredSound, player: IPlayer)
    protected abstract fun playSound(soundSet: ConfiguredSoundSet, sound: ConfiguredSound, location: ConfiguredDoubleLocation)
}