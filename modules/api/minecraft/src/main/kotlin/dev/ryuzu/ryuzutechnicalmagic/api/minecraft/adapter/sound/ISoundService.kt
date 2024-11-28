package dev.ryuzu.ryuzutechnicalmagic.api.minecraft.adapter.sound

import dev.ryuzu.ryuzutechnicalmagic.api.core.model.configuration.base.ConfiguredDoubleLocation
import dev.ryuzu.ryuzutechnicalmagic.api.core.model.configuration.util.effect.sound.ConfiguredSoundSet
import dev.ryuzu.ryuzutechnicalmagic.api.core.model.scheduler.TaskUnit

interface ISoundService {
    fun convertTaskUnits(soundSets: Set<ConfiguredSoundSet>, players: Set<dev.ryuzu.ryuzutechnicalmagic.api.core.model.entity.IPlayer>): Set<TaskUnit>
    fun convertTaskUnits(soundSets: Set<ConfiguredSoundSet>, location: ConfiguredDoubleLocation): Set<TaskUnit>
    fun playSound(soundSets: Set<ConfiguredSoundSet>, players: Set<dev.ryuzu.ryuzutechnicalmagic.api.core.model.entity.IPlayer>)
    fun playSound(soundSets: Set<ConfiguredSoundSet>, vararg players: dev.ryuzu.ryuzutechnicalmagic.api.core.model.entity.IPlayer) = playSound(soundSets, players.toSet())
    fun playSound(soundSets: Set<ConfiguredSoundSet>, location: ConfiguredDoubleLocation)
}

