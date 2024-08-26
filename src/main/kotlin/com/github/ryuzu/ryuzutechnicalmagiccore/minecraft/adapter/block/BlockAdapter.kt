package com.github.ryuzu.ryuzutechnicalmagiccore.minecraft.adapter.block

import com.github.ryuzu.ryuzutechnicalmagiccore.core.adapter.block.IBlockAdapter
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.base.ConfiguredIntLocation
import com.github.ryuzu.ryuzutechnicalmagiccore.minecraft.model.block.IBlockProvider
import com.github.ryuzu.ryuzutechnicalmagiccore.minecraft.util.ConfiguredUtility.Companion.toBlockLocation
import org.bukkit.Material
import org.koin.core.annotation.Single
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

@Single([IBlockAdapter::class])
class BlockAdapter : IBlockAdapter, KoinComponent {
    private val blockProvider: IBlockProvider by inject()

    override fun setBlock(location: ConfiguredIntLocation, block: String) {
        try {
            val material = Material.getMaterial(block)
            location.toBlockLocation().world.setBlockData(location.toBlockLocation(), material?.createBlockData() ?: throw IllegalArgumentException("This id is not a valid block id."))
        } catch (e: Exception) {
            blockProvider.setBlock(location, block)
        }
    }
}