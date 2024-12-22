package dev.ryuzu.ryuzutechnicalmagic.api.minecraft.adapter.block

import dev.ryuzu.ryuzutechnicalmagic.api.core.data.base.SerIntLocation


interface IBlockAdapter {
    fun setBlock(location: SerIntLocation, id: String)
    fun getBlockId(location: SerIntLocation): String
    fun getHardness(id: String): Int
    fun setBlockDestroyState(location: SerIntLocation, destroyState: Byte)
}