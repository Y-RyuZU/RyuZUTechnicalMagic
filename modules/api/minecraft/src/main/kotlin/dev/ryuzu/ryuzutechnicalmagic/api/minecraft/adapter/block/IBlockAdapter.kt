package dev.ryuzu.ryuzutechnicalmagic.api.minecraft.adapter.block

import dev.ryuzu.ryuzutechnicalmagic.api.core.configuration.data.base.ConfiguredIntLocation


interface IBlockAdapter {
    fun setBlock(location: ConfiguredIntLocation, id: String)
    fun getBlockId(location: ConfiguredIntLocation): String
    fun getHardness(id: String): Int
    fun setBlockDestroyState(location: ConfiguredIntLocation, destroyState: Byte)
}