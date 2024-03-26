package com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.game.entry

import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.base.ConfiguredIntVector
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.util.ConfiguredEffect
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.util.display.IConfiguredDisplay

data class ConfiguredEntry(
    val structure: String,
    val block: String,
    val display: IConfiguredDisplay.ConfiguredTextDisplay,
    val effects: ConfiguredEffect,
    val points: Set<ConfiguredIntVector>,
    val worlds: Set<String>
)