package com.github.ryuzu.ryuzutechnicalmagiccore.core.util.sound

import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.util.sound.ConfiguredSoundSet
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.game.player.IGamePlayer
import com.github.ryuzu.ryuzutechnicalmagiccore.core.util.scheduler.TaskUnit
import org.koin.core.component.KoinComponent
import java.util.*

interface ISoundService : KoinComponent {
    fun convertTaskUnits(soundSets: Set<ConfiguredSoundSet>, players: Set<UUID>): Set<TaskUnit>
    fun playSound(soundSets: Set<ConfiguredSoundSet>, players: Set<UUID>)
    fun playSound(soundSets: Set<ConfiguredSoundSet>, vararg players: UUID)
}