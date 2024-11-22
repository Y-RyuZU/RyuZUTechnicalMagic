package dev.ryuzu.ryuzutechnicalmagicapi.model.configuration.game.mode

import dev.ryuzu.ryuzutechnicalmagicapi.model.configuration.util.effect.ConfiguredEffect

data class ConfiguredGameMode (
    val display: ConfiguredGameModeDisplay,
    val effect: ConfiguredEffect,
    val parameter: IConfiguredGameModeParameter,
)