package dev.ryuzu.ryuzutechnicalmagic.api.core.model.configuration.game.mode

import dev.ryuzu.ryuzutechnicalmagic.api.core.model.configuration.util.effect.ConfiguredEffect

data class ConfiguredGameMode (
    val display: ConfiguredGameModeDisplay,
    val effect: ConfiguredEffect,
    val parameter: IConfiguredGameModeParameter,
)