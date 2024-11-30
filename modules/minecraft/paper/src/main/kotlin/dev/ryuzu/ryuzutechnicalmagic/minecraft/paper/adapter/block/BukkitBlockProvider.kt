package dev.ryuzu.ryuzutechnicalmagic.minecraft.paper.adapter.block

import dev.ryuzu.ryuzutechnicalmagic.api.core.configuration.data.base.ConfiguredIntLocation
import dev.ryuzu.ryuzutechnicalmagic.api.minecraft.adapter.block.IBlockAdapter
import dev.ryuzu.ryuzutechnicalmagic.minecraft.paper.util.ConfiguredUtility.Companion.toBlockLocation
import org.bukkit.Material
import org.koin.core.annotation.Single

@Single([IBlockAdapter::class])
class BukkitBlockProvider : IBlockProvider {
    override val priority: Int = 200

    override fun setBlock(location: ConfiguredIntLocation, id: String) {
        val blockLocation = location.toBlockLocation()
        val block = blockLocation.block
        block.type = Material.getMaterial(id) ?: throw IllegalArgumentException("Invalid block id: $id")
    }

    override fun getBlockId(location: ConfiguredIntLocation): String =
        location.toBlockLocation().block.type.name

    override fun existsId(id: String): Boolean =
        Material.getMaterial(id) != null


    override fun exitsBlock(location: ConfiguredIntLocation): Boolean =
        location.toBlockLocation().block.type != Material.AIR

    override fun getHardness(id: String): Int =
        Material.getMaterial(id)?.hardness?.toInt() ?: 0
}