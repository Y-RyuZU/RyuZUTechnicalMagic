package dev.ryuzu.ryuzutechnicalmagic.api.core.configuration.skill

import dev.ryuzu.ryuzutechnicalmagic.api.core.configuration.skill.param.ISkillParams
import dev.ryuzu.ryuzutechnicalmagic.api.core.configuration.util.effect.ConfiguredEffect

data class ConfiguredSkillParams (
    val id: String,
    val coolTime: Long = 0,
    val relationExpirationTime: Long = 0,
    val effect: dev.ryuzu.ryuzutechnicalmagic.api.core.configuration.util.effect.ConfiguredEffect,
    val performance: dev.ryuzu.ryuzutechnicalmagic.api.core.configuration.skill.param.ISkillParams
)