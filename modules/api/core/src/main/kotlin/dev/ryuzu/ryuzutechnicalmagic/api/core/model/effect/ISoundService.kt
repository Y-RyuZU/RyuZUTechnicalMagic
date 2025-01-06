package dev.ryuzu.ryuzutechnicalmagic.api.core.model.effect

import dev.ryuzu.ryuzutechnicalmagic.api.core.data.base.SerDoubleLocation
import dev.ryuzu.ryuzutechnicalmagic.api.core.data.effect.sound.SerSoundSet
import dev.ryuzu.ryuzutechnicalmagic.api.core.model.entity.IPlayer
import dev.ryuzu.ryuzutechnicalmagic.api.core.model.scheduler.TaskUnit

interface ISoundService {
    fun convertTaskUnits(soundSets: Set<SerSoundSet>, vararg players: IPlayer): Set<TaskUnit>
    fun convertTaskUnits(soundSets: Set<SerSoundSet>, location: SerDoubleLocation): Set<TaskUnit>
    fun playSound(soundSets: Set<SerSoundSet>, vararg players: IPlayer)
    fun playSound(soundSets: Set<SerSoundSet>, location: SerDoubleLocation)
}

