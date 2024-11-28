package dev.ryuzu.ryuzutechnicalmagic.api.core.model.configuration.skill

import dev.ryuzu.ryuzutechnicalmagic.api.core.model.configuration.skill.param.ISkillParams
import dev.ryuzu.ryuzutechnicalmagic.api.core.model.configuration.util.effect.ConfiguredEffect

data class ConfiguredSkillParams (
    val id: String,
    val coolTime: Long = 0,
    val relationExpirationTime: Long = 0,
    val effect: ConfiguredEffect,
    val performance: ISkillParams
)