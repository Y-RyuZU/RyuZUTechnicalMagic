package dev.ryuzu.ryuzutechnicalmagiccore.util.wrapper.sound

import dev.ryuzu.ryuzutechnicalmagiccore.model.configuration.base.ConfiguredDoubleLocation
import dev.ryuzu.ryuzutechnicalmagiccore.model.configuration.util.effect.sound.ConfiguredSoundSet
import dev.ryuzu.ryuzutechnicalmagiccore.model.entity.IPlayer
import dev.ryuzu.ryuzutechnicalmagiccore.model.scheduler.TaskUnit
import org.koin.core.component.KoinComponent

interface ISoundService : KoinComponent {
    fun convertTaskUnits(soundSets: Set<ConfiguredSoundSet>, players: Set<IPlayer>): Set<TaskUnit>
    fun convertTaskUnits(soundSets: Set<ConfiguredSoundSet>, location: ConfiguredDoubleLocation): Set<TaskUnit>
    fun playSound(soundSets: Set<ConfiguredSoundSet>, players: Set<IPlayer>)
    fun playSound(soundSets: Set<ConfiguredSoundSet>, vararg players: IPlayer) = playSound(soundSets, players.toSet())
    fun playSound(soundSets: Set<ConfiguredSoundSet>, location: ConfiguredDoubleLocation)

}

