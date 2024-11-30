package dev.ryuzu.ryuzutechnicalmagic.api.core.model.skill.service

interface ICoolTimeService {
    fun getCoolTime(player: dev.ryuzu.ryuzutechnicalmagic.api.core.model.entity.IPlayer, skillId: String): Long
    fun setCoolTime(player: dev.ryuzu.ryuzutechnicalmagic.api.core.model.entity.IPlayer, skillId: String, coolTime: Long)
    fun resetCoolTime(player: dev.ryuzu.ryuzutechnicalmagic.api.core.model.entity.IPlayer, skillId: String)
    fun addCoolTime(player: dev.ryuzu.ryuzutechnicalmagic.api.core.model.entity.IPlayer, skillId: String, coolTime: Long)
}