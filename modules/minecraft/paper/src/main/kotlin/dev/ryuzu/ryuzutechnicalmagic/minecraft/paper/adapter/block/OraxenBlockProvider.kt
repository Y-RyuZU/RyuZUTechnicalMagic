package dev.ryuzu.ryuzutechnicalmagic.minecraft.paper.adapter.block

import dev.ryuzu.ryuzutechnicalmagic.api.core.configuration.data.base.ConfiguredIntLocation
import dev.ryuzu.ryuzutechnicalmagic.api.minecraft.adapter.block.IBlockAdapter
import dev.ryuzu.ryuzutechnicalmagic.minecraft.paper.util.ConfiguredUtility.Companion.toBlockLocation
import io.th0rgal.oraxen.api.OraxenBlocks
import org.koin.core.annotation.Single

@Single([IBlockAdapter::class])
class OraxenBlockProvider : IBlockProvider {
    override val priority: Int = 0

    override fun setBlock(location: ConfiguredIntLocation, id: String) {
        OraxenBlocks.place(id, location.toBlockLocation())
    }

    override fun getBlockId(location: ConfiguredIntLocation): String? =
        OraxenBlocks.getOraxenBlock(location.toBlockLocation())?.itemID

    override fun existsId(id: String): Boolean =
        OraxenBlocks.getBlockIDs().contains(id)

    override fun exitsBlock(location: ConfiguredIntLocation): Boolean =
        OraxenBlocks.getOraxenBlock(location.toBlockLocation()) != null

    override fun getHardness(id: String): Int =
        OraxenBlocks.getNoteBlockMechanic(id)?.hardness ?: 0
}