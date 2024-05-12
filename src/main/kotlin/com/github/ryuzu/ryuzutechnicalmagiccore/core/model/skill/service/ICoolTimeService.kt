package com.github.ryuzu.ryuzutechnicalmagiccore.core.model.skill.service

import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.entity.IPlayer

interface ICoolTimeService {
    fun getCoolTime(player: IPlayer, skillId: String): Long
    fun setCoolTime(player: IPlayer, skillId: String, coolTime: Long)
    fun resetCoolTime(player: IPlayer, skillId: String)
    fun addCoolTime(player: IPlayer, skillId: String, coolTime: Long)
}