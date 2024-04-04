package com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.skill.param

data class SimpleShootParams(
    val penetrationEntity: Boolean = true,
    val penetrationBlock: Boolean = false,
    val speed: Double = 0.0,
    val damage: Double = 0.0,
    val hitBox: Double = 0.0,
    val endDamage: Double = 0.0,
    val endDamageHitBox: Double = 0.0,
    val repeat: Int = 0,
    val maxRepeat: Int = 0,
) : ISkillParams