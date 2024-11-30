package dev.ryuzu.ryuzutechnicalmagic.core.impl.model.block

import dev.ryuzu.ryuzutechnicalmagic.api.core.configuration.data.base.ConfiguredIntLocation
import dev.ryuzu.ryuzutechnicalmagic.api.core.configuration.data.block.BlockTag
import dev.ryuzu.ryuzutechnicalmagic.api.core.configuration.data.general.ConfiguredGeneralParameter
import dev.ryuzu.ryuzutechnicalmagic.api.core.model.block.BlockDamageData
import dev.ryuzu.ryuzutechnicalmagic.api.core.model.block.BlockState
import dev.ryuzu.ryuzutechnicalmagic.api.minecraft.adapter.block.IBlockAdapter
import dev.ryuzu.ryuzutechnicalmagic.api.core.model.block.IBlockStateService
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import org.koin.core.qualifier.named

class BlockStateServiceImpl : IBlockStateService, KoinComponent {
    private val blockAdapter: IBlockAdapter by inject()
    private val config: ConfiguredGeneralParameter by inject()
    private val blockDefaultState: Map<String, List<BlockTag>> by inject(named("BlockDefaultStateConfig"))
    private val blockStateMap: HashMap<ConfiguredIntLocation, BlockState> = hashMapOf()

    private fun removeOldHistories() {
        val currentTime = System.currentTimeMillis()
        val lifetimeSeconds = config.damageHistoryParameter.lifeTime * 50
        blockStateMap.values.forEach {
            it.damageHistories.removeIf { history -> history.startedAt + lifetimeSeconds < currentTime }
        }
    }

    fun applyDamage(location: ConfiguredIntLocation, damage: Int) {
        val blockState = blockStateMap.getOrPut(location) {
            val id = blockAdapter.getBlockId(location)
            val defaultBlockTag: List<BlockTag> = blockDefaultState.getOrDefault(id, emptyList())
            val hardness = blockAdapter.getHardness(id)
            BlockState(defaultBlockTag, hardness)
        }
        blockState.damageHistories.add(BlockDamageData(damage))

        if (blockState.isBroken()) {
            blockAdapter.setBlockDestroyState(location, 10)
            blockStateMap.remove(location)
            blockAdapter.setBlock(location, "AIR")
        }
    }

    fun clearState(location: ConfiguredIntLocation) {
        blockStateMap.remove(location)
    }

    fun recoverBlock(location: ConfiguredIntLocation) {
        blockAdapter.setBlockDestroyState(location, 0)
        blockStateMap[location]?.damageHistories?.clear()
    }
}