package dev.ryuzu.ryuzutechnicalmagic.api.core.configuration.data.game.mode

import dev.ryuzu.ryuzutechnicalmagic.api.core.configuration.skill.effect.ConfiguredEffect

data class ConfiguredGameMode (
    val display: dev.ryuzu.ryuzutechnicalmagic.api.core.configuration.data.game.mode.ConfiguredGameModeDisplay,
    val effect: ConfiguredEffect,
    val parameter: dev.ryuzu.ryuzutechnicalmagic.api.core.configuration.data.game.mode.IConfiguredGameModeParameter,
)