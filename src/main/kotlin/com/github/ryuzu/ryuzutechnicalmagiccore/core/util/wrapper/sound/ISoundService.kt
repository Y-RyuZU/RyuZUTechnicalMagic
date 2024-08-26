package com.github.ryuzu.ryuzutechnicalmagiccore.core.util.wrapper.sound

import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.base.ConfiguredDoubleLocation
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.util.effect.sound.ConfiguredSoundSet
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.entity.IPlayer
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.scheduler.TaskUnit
import org.koin.core.component.KoinComponent

interface ISoundService : KoinComponent {
    fun convertTaskUnits(soundSets: Set<ConfiguredSoundSet>, players: Set<IPlayer>): Set<TaskUnit>
    fun convertTaskUnits(soundSets: Set<ConfiguredSoundSet>, location: ConfiguredDoubleLocation): Set<TaskUnit>
    fun playSound(soundSets: Set<ConfiguredSoundSet>, players: Set<IPlayer>)
    fun playSound(soundSets: Set<ConfiguredSoundSet>, vararg players: IPlayer) = playSound(soundSets, players.toSet())
    fun playSound(soundSets: Set<ConfiguredSoundSet>, location: ConfiguredDoubleLocation)

}

