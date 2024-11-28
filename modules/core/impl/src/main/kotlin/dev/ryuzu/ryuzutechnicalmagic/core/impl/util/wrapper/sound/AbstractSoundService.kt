package dev.ryuzu.ryuzutechnicalmagic.core.impl.util.wrapper.sound

import dev.ryuzu.ryuzutechnicalmagic.api.core.model.configuration.base.ConfiguredDoubleLocation
import dev.ryuzu.ryuzutechnicalmagic.api.core.model.configuration.util.effect.sound.ConfiguredSound
import dev.ryuzu.ryuzutechnicalmagic.api.core.model.configuration.util.effect.sound.ConfiguredSoundSet
import dev.ryuzu.ryuzutechnicalmagic.api.core.model.entity.IPlayer
import dev.ryuzu.ryuzutechnicalmagic.api.core.model.scheduler.TaskUnit
import dev.ryuzu.ryuzutechnicalmagic.api.minecraft.adapter.sound.ISoundService
import dev.ryuzu.ryuzutechnicalmagic.core.impl.model.scheduler.SimpleSchedulerFactory
import org.koin.core.component.KoinComponent

import org.koin.core.component.inject

abstract class AbstractSoundService : ISoundService, KoinComponent {
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
        schedulerFactory.createSimpleScheduler().schedule(convertTaskUnits(soundSets, players)).runSync()
    }

    override fun playSound(soundSets: Set<ConfiguredSoundSet>, location: ConfiguredDoubleLocation) {
        schedulerFactory.createSimpleScheduler().schedule(convertTaskUnits(soundSets, location)).runSync()
    }

    protected abstract fun playSound(soundSet: ConfiguredSoundSet, sound: ConfiguredSound, player: IPlayer)
    protected abstract fun playSound(soundSet: ConfiguredSoundSet, sound: ConfiguredSound, location: ConfiguredDoubleLocation)
}