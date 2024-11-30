package dev.ryuzu.ryuzutechnicalmagic.api.core.configuration.data.skill

import dev.ryuzu.ryuzutechnicalmagic.api.core.configuration.skill.effect.ConfiguredEffect

data class ConfiguredSkillParams (
    val id: String,
    val coolTime: Long = 0,
    val relationExpirationTime: Long = 0,
    val effect: ConfiguredEffect,
    val performance: dev.ryuzu.ryuzutechnicalmagic.api.core.configuration.skill.param.ISkillParams
)