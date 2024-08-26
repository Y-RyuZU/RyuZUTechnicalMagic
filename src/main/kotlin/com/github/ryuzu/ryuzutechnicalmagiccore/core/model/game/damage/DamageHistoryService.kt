package com.github.ryuzu.ryuzutechnicalmagiccore.core.model.game.damage

import com.github.ryuzu.ryuzutechnicalmagiccore.core.event.data.damage.IEntityDamageEvent
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.general.ConfiguredGeneralParameter
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.entity.IPlayer
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class DamageHistoryService : IDamageHistoryService, KoinComponent {
    private val config: ConfiguredGeneralParameter by inject()
    private val histories: HashMap<IPlayer, MutableList<DamageHistoryData>> = hashMapOf()

    override fun add(event: IEntityDamageEvent) {
        if(event.entity !is IPlayer) return
        val player = event.entity as IPlayer
        histories.getOrPut(player) { mutableListOf() }.add(DamageHistoryData(event))
    }

    override fun removeOldHistories(player: IPlayer) {
        histories[player]?.let { removePlayerOldHistories(it) }
    }

    override fun removeAllPlayerOldHistories() {
        histories.values.forEach { removePlayerOldHistories(it) }
    }

    private fun removePlayerOldHistories(histories: MutableList<DamageHistoryData>) {
        val now = System.currentTimeMillis()
        histories.removeIf { it.startedAt + (config.damageHistoryParameter.lifeTime * 50) < now }
    }
}