package dev.ryuzu.ryuzutechnicalmagic.core.impl.model.game.damage

import dev.ryuzu.ryuzutechnicalmagic.api.core.event.data.damage.IEntityDamageEvent
import dev.ryuzu.ryuzutechnicalmagic.api.core.model.configuration.general.ConfiguredGeneralParameter
import dev.ryuzu.ryuzutechnicalmagic.api.core.model.entity.IPlayer
import dev.ryuzu.ryuzutechnicalmagic.api.core.model.game.damage.DamageHistoryData
import dev.ryuzu.ryuzutechnicalmagic.api.core.model.game.damage.IDamageHistoryService
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