package data.block

import dev.ryuzu.ryuzutechnicalmagic.api.core.data.block.BlockTag

data class BlockState(
    val tags: List<BlockTag>,
    val durability: Int
) {
    val damageHistories: MutableList<BlockDamageData> = mutableListOf()

    fun getCurrentDurability(): Int {
        return durability - damageHistories.sumOf { it.damage }
    }

    fun isBroken(): Boolean {
        return getCurrentDurability() <= 0
    }
}
