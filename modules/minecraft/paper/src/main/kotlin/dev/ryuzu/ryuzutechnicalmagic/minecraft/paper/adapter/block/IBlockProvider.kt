package dev.ryuzu.ryuzutechnicalmagic.minecraft.paper.adapter.block

import dev.ryuzu.ryuzutechnicalmagic.api.core.data.base.SerIntLocation

interface IBlockProvider {
    val priority: Int

    fun setBlock(location: SerIntLocation, id: String)
    fun getBlockId(location: SerIntLocation): String?
    fun existsId(id: String): Boolean
    fun exitsBlock(location: SerIntLocation): Boolean
    fun getHardness(id: String): Int
}