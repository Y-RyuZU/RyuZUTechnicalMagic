package dev.ryuzu.ryuzutechnicalmagiccore.model.configuration.game.mode

import dev.ryuzu.ryuzutechnicalmagiccore.model.configuration.util.effect.ConfiguredEffect

data class ConfiguredGameMode (
    val display: ConfiguredGameModeDisplay,
    val effect: ConfiguredEffect,
    val parameter: IConfiguredGameModeParameter,
)