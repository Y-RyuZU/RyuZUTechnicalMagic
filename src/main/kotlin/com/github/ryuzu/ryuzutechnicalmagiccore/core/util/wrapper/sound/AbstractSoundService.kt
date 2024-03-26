package com.github.ryuzu.ryuzutechnicalmagiccore.core.util.wrapper.sound

import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.base.ConfiguredDoubleLocation
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.util.sound.ConfiguredSound
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.util.sound.ConfiguredSoundSet
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.player.IPlayer
import com.github.ryuzu.ryuzutechnicalmagiccore.core.util.scheduler.TaskUnit
import com.github.ryuzu.ryuzutechnicalmagiccore.core.util.scheduler.SimpleSchedulerFactory

import org.koin.core.component.inject
import java.util.*

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

    override fun playSound(soundSets: Set<ConfiguredSoundSet>, players: Set<IPlayer>) {
        schedulerFactory.createScheduler().schedule(convertTaskUnits(soundSets, players)).runSync()
    }

    protected abstract fun playSound(soundSet: ConfiguredSoundSet, sound: ConfiguredSound, player: IPlayer)
}