package dev.ryuzu.ryuzutechnicalmagiccore.model.block

import dev.ryuzu.ryuzutechnicalmagiccore.model.configuration.base.ConfiguredIntLocation

interface IBlockService {
    fun setBlock(location: ConfiguredIntLocation, block: String)
    fun getBlockState(location: ConfiguredIntLocation)
}