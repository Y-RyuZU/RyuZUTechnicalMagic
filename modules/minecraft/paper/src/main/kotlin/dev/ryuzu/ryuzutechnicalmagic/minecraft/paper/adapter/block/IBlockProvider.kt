package dev.ryuzu.ryuzutechnicalmagic.minecraft.paper.adapter.block

import dev.ryuzu.ryuzutechnicalmagic.api.core.configuration.data.base.ConfiguredIntLocation
import org.bukkit.inventory.ItemStack

interface IBlockProvider {
    val priority: Int

    fun setBlock(location: ConfiguredIntLocation, id: String)
    fun getBlockId(location: ConfiguredIntLocation): String?
    fun existsId(id: String): Boolean
    fun exitsBlock(location: ConfiguredIntLocation): Boolean
    fun getHardness(id: String): Int
}