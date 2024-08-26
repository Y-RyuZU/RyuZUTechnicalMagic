package com.github.ryuzu.ryuzutechnicalmagiccore.core.model.block

import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.general.ConfiguredGeneralParameter
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.game.damage.DamageHistoryData
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class BlockDurabilityContainer : KoinComponent {
    private val config: ConfiguredGeneralParameter by inject()
    val histories: MutableList<BlockDamageData> = mutableListOf()





    private fun removeOldHistories(histories: MutableList<DamageHistoryData>) {
        val now = System.currentTimeMillis()
        histories.removeIf { it.startedAt + (config.damageHistoryParameter.lifeTime * 50) < now }
    }
}