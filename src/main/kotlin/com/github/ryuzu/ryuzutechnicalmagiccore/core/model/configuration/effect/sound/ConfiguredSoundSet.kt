package com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.effect.sound

import com.github.ryuzu.ryuzutechnicalmagiccore.core.util.scheduler.TaskUnit
import java.util.*

data class ConfiguredSoundSet(
    val category: String = "MASTER",
    val listenerOnly: Boolean = false,
    val sounds: Set<ConfiguredSound>
)
