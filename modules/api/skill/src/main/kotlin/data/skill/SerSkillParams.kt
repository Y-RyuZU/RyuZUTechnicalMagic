package data.skill

import data.skill.param.ISerSkillParams
import dev.ryuzu.ryuzutechnicalmagic.api.core.data.effect.SerEffect


data class SerSkillParams (
    val id: String,
    val coolTime: Long = 0,
    val relationExpirationTime: Long = 0,
    val effect: SerEffect,
    val performance: ISerSkillParams
)