package dev.ryuzu.ryuzutechnicalmagic.api.game.data.mode

import dev.ryuzu.ryuzutechnicalmagic.api.core.data.effect.SerEffect

data class ConfiguredGameMode (
    val display: ConfiguredGameModeDisplay,
    val effect: SerEffect,
    val parameter: IConfiguredGameModeParameter,
)