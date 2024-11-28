package dev.ryuzu.ryuzutechnicalmagic.minecraft.paper.implementation.util.wrapper.block

import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.base.ConfiguredDoubleLocation
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.base.ConfiguredDoubleVector
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.base.ConfiguredIntLocation
import com.github.ryuzu.ryuzutechnicalmagiccore.core.util.wrapper.block.IBlockService
import com.github.ryuzu.ryuzutechnicalmagiccore.core.util.wrapper.structure.IStructureService
import dev.ryuzu.ryuzutechnicalmagic.minecraft.paper.model.block.IBlockProvider
import dev.ryuzu.ryuzutechnicalmagic.minecraft.paper.util.ConfiguredUtility.Companion.toBlockLocation
import dev.ryuzu.ryuzutechnicalmagic.minecraft.paper.util.ConfiguredUtility.Companion.toLocation
import dev.ryuzu.ryuzutechnicalmagic.minecraft.paper.util.ConfiguredUtility.Companion.toVector
import org.bukkit.FluidCollisionMode
import org.bukkit.Material
import org.bukkit.util.RayTraceResult
import org.koin.core.annotation.Single
import org.koin.core.component.inject

@Single([IBlockService::class])
class BlockService : IBlockService {
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