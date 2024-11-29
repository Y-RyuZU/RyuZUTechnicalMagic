package dev.ryuzu.ryuzutechnicalmagic.api.core.configuration.game.mode

import dev.ryuzu.ryuzutechnicalmagic.api.core.configuration.util.effect.ConfiguredEffect

data class ConfiguredGameMode (
    val display: ConfiguredGameModeDisplay,
    val effect: dev.ryuzu.ryuzutechnicalmagic.api.core.configuration.util.effect.ConfiguredEffect,
    val parameter: IConfiguredGameModeParameter,
)