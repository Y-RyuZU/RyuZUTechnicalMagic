package com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.skill

import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.skill.param.ISkillParams
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.util.ConfiguredEffect
import com.github.ryuzu.ryuzutechnicalmagiccore.core.util.TypedMap

data class ConfiguredSkillParams (
    val id: String,
    val coolTime: Long = 0,
    val relationExpirationTime: Long = 0,
    val effect: ConfiguredEffect,
    val performance: ISkillParams
)