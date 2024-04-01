package com.github.ryuzu.ryuzutechnicalmagiccore.core.model.skill.service

import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.player.IPlayer
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.player.setting.IPlayerPersistentDataService
import org.koin.core.annotation.Single
import kotlin.math.max

@Single([ICoolTimeService::class])
class CoolTimeService : ICoolTimeService {
    private val coolTimeMap: MutableMap<IPlayer, MutableMap<String, Long>> = mutableMapOf()

    override fun getCoolTime(player: IPlayer, skillId: String): Long
        = max(coolTimeMap.getOrPut(player) { mutableMapOf() }.getOrDefault(skillId, 0) - System.currentTimeMillis(), 0L)

    override fun setCoolTime(player: IPlayer, skillId: String, coolTime: Long) {
        coolTimeMap.getOrPut(player) { mutableMapOf() }[skillId] = System.currentTimeMillis() + coolTime
    }

    override fun resetCoolTime(player: IPlayer, skillId: String) {
        setCoolTime(player, skillId, 0L)
    }

    override fun addCoolTime(player: IPlayer, skillId: String, coolTime: Long) {
        coolTimeMap.getOrPut(player) { mutableMapOf() }[skillId] = getCoolTime(player, skillId) + coolTime
    }
}