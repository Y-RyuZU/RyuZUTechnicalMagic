package dev.ryuzu.ryuzutechnicalmagic.api.game.data.mode

import dev.ryuzu.ryuzutechnicalmagic.api.core.configuration.skill.effect.ConfiguredEffect

data class ConfiguredGameMode (
    val display: dev.ryuzu.ryuzutechnicalmagic.api.game.data.mode.ConfiguredGameModeDisplay,
    val effect: ConfiguredEffect,
    val parameter: dev.ryuzu.ryuzutechnicalmagic.api.game.data.mode.IConfiguredGameModeParameter,
)