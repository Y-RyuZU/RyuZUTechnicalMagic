package dev.ryuzu.ryuzutechnicalmagicapi.model.block

import dev.ryuzu.ryuzutechnicalmagicapi.model.configuration.base.ConfiguredIntLocation

interface IBlockService {
    fun setBlock(location: ConfiguredIntLocation, block: String)
    fun getBlockState(location: ConfiguredIntLocation)
}