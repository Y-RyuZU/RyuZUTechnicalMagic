package dev.ryuzu.ryuzutechnicalmagic.api.core.model.effect

import dev.ryuzu.ryuzutechnicalmagic.api.core.data.base.SerDoubleLocation
import dev.ryuzu.ryuzutechnicalmagic.api.core.configuration.skill.effect.sound.ConfiguredSoundSet
import dev.ryuzu.ryuzutechnicalmagic.api.core.model.entity.IPlayer
import dev.ryuzu.ryuzutechnicalmagic.api.core.model.scheduler.TaskUnit

interface ISoundService {
    fun convertTaskUnits(soundSets: Set<ConfiguredSoundSet>, vararg players: IPlayer): Set<TaskUnit>
    fun convertTaskUnits(soundSets: Set<ConfiguredSoundSet>, location: SerDoubleLocation): Set<TaskUnit>
    fun playSound(soundSets: Set<ConfiguredSoundSet>, vararg players: IPlayer)
    fun playSound(soundSets: Set<ConfiguredSoundSet>, location: SerDoubleLocation)
}

