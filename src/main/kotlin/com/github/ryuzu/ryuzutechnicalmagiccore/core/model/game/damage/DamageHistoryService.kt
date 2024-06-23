package com.github.ryuzu.ryuzutechnicalmagiccore.core.model.game.damage

import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.general.ConfiguredGeneralParameter
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.entity.IPlayer
import org.koin.core.component.inject

class DamageHistoryService : IDamageHistoryService {
    private val config: ConfiguredGeneralParameter by inject()
    private val histories: HashMap<IPlayer, MutableList<DamageHistoryData>> = hashMapOf()

    override fun add(event: IPlayerDamageEvent) {
        histories.getOrPut(event.player) { mutableListOf() }.add(DamageHistoryData(event))
    }

    override fun removeOldHistories(player: IPlayer) {
        histories[player]?.let { removePlayerOldHistories(it) }
    }

    override fun removeAllPlayerOldHistories() {
        histories.values.forEach { removePlayerOldHistories(it) }
    }

    private fun removePlayerOldHistories(histories: MutableList<DamageHistoryData>) {
        val now = System.currentTimeMillis()
        histories.removeIf { it.time + (config.damageHistoryParameter.lifeTime * 50) < now }
    }
}