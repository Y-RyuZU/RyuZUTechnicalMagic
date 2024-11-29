package dev.ryuzu.ryuzutechnicalmagic.core.impl.util.wrapper.sound

import dev.ryuzu.ryuzutechnicalmagic.api.core.configuration.base.ConfiguredDoubleLocation
import dev.ryuzu.ryuzutechnicalmagic.api.core.configuration.util.effect.sound.ConfiguredSoundSet
import dev.ryuzu.ryuzutechnicalmagic.api.core.model.entity.IPlayer
import dev.ryuzu.ryuzutechnicalmagic.api.core.model.scheduler.TaskUnit
import dev.ryuzu.ryuzutechnicalmagic.api.minecraft.adapter.effect.IEffectAdapter
import dev.ryuzu.ryuzutechnicalmagic.api.core.model.effect.ISoundService
import dev.ryuzu.ryuzutechnicalmagic.core.impl.model.scheduler.SimpleSchedulerFactory
import org.koin.core.annotation.Single
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

@Single([ISoundService::class])
class SoundServiceImpl : ISoundService, KoinComponent {
    private val schedulerFactory: SimpleSchedulerFactory by inject()
    private val effectAdapter: IEffectAdapter by inject()

    override fun convertTaskUnits(soundSets: Set<ConfiguredSoundSet>, vararg players: IPlayer): Set<TaskUnit> {
        return soundSets.flatMap { soundSet ->
            soundSet.sounds.map { sound ->
                TaskUnit(sound.delay) { _, _ ->
                    players
                        .forEach {
                            effectAdapter.playSound(soundSet, sound, it)
                        }
                }
            }
        }.toSet()
    }

    override fun convertTaskUnits(soundSets: Set<ConfiguredSoundSet>, location: ConfiguredDoubleLocation): Set<TaskUnit> {
        return soundSets.flatMap { soundSet ->
            soundSet.sounds.map { sound ->
                TaskUnit(sound.delay) { _, _ ->
                    effectAdapter.playSound(soundSet, sound, location)
                }
            }
        }.toSet()
    }

    override fun playSound(soundSets: Set<ConfiguredSoundSet>, vararg players: IPlayer) {
        schedulerFactory.createSimpleScheduler().schedule(convertTaskUnits(soundSets, *players)).runSync()
    }

    override fun playSound(soundSets: Set<ConfiguredSoundSet>, location: ConfiguredDoubleLocation) {
        schedulerFactory.createSimpleScheduler().schedule(convertTaskUnits(soundSets, location)).runSync()
    }
}