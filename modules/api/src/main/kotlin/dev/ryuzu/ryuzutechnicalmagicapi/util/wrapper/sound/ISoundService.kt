package dev.ryuzu.ryuzutechnicalmagicapi.util.wrapper.sound

import dev.ryuzu.ryuzutechnicalmagicapi.model.configuration.base.ConfiguredDoubleLocation
import dev.ryuzu.ryuzutechnicalmagicapi.model.configuration.util.effect.sound.ConfiguredSoundSet
import dev.ryuzu.ryuzutechnicalmagicapi.model.entity.IPlayer
import dev.ryuzu.ryuzutechnicalmagicapi.model.scheduler.TaskUnit

interface ISoundService {
    fun convertTaskUnits(soundSets: Set<ConfiguredSoundSet>, players: Set<IPlayer>): Set<TaskUnit>
    fun convertTaskUnits(soundSets: Set<ConfiguredSoundSet>, location: ConfiguredDoubleLocation): Set<TaskUnit>
    fun playSound(soundSets: Set<ConfiguredSoundSet>, players: Set<IPlayer>)
    fun playSound(soundSets: Set<ConfiguredSoundSet>, vararg players: IPlayer) = playSound(soundSets, players.toSet())
    fun playSound(soundSets: Set<ConfiguredSoundSet>, location: ConfiguredDoubleLocation)
}

