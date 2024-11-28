package dev.ryuzu.ryuzutechnicalmagic.minecraft.paper.adapter.block

import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.base.ConfiguredIntLocation
import dev.ryuzu.ryuzutechnicalmagic.minecraft.paper.util.ConfiguredUtility.Companion.toBlockLocation
import io.th0rgal.oraxen.api.OraxenBlocks
import org.koin.core.annotation.Single

@Single([dev.ryuzu.ryuzutechnicalmagic.minecraft.paper.adapter.block.IBlockProvider::class])
class OraxenBlockProvider : dev.ryuzu.ryuzutechnicalmagic.minecraft.paper.adapter.block.IBlockProvider {
    override fun setBlock(location: ConfiguredIntLocation, block: String) {
        OraxenBlocks.place(block, location.toBlockLocation())
    }
}