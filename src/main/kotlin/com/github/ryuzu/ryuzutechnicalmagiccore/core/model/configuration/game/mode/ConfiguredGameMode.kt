package com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.game.mode

import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.reward.ConfiguredReward
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.util.ConfiguredEffect

data class ConfiguredGameMode (
    val display: ConfiguredGameModeDisplay,
    val effect: ConfiguredEffect,
    val parameter: IConfiguredGameModeParameter,
)