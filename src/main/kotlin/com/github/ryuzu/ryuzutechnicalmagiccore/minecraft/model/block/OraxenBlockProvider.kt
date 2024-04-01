package com.github.ryuzu.ryuzutechnicalmagiccore.minecraft.model.block

import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.base.ConfiguredIntLocation
import com.github.ryuzu.ryuzutechnicalmagiccore.core.util.wrapper.block.IBlockService
import com.github.ryuzu.ryuzutechnicalmagiccore.minecraft.util.ConfiguredUtility.Companion.toBlockLocation
import io.th0rgal.oraxen.api.OraxenBlocks
import org.koin.core.annotation.Single

@Single([IBlockProvider::class])
class OraxenBlockProvider : IBlockProvider {
    override fun setBlock(location: ConfiguredIntLocation, block: String) {
        OraxenBlocks.place(block, location.toBlockLocation())
    }
}