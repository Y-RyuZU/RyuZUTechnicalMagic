package com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.game.mode

import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.util.effect.ConfiguredEffect

data class ConfiguredGameMode (
    val display: ConfiguredGameModeDisplay,
    val effect: ConfiguredEffect,
    val parameter: IConfiguredGameModeParameter,
)