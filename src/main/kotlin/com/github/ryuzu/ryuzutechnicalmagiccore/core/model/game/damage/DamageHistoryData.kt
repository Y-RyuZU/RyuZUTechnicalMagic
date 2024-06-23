package com.github.ryuzu.ryuzutechnicalmagiccore.core.model.game.damage

import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.skill.param.ISkillEventPrams.ICasterEventParams.CasterEventParams.IDamageEventParams

data class DamageHistoryData(
    val eventParam: IPlayerDamageEvent,
    val time: Long = System.currentTimeMillis()
)
