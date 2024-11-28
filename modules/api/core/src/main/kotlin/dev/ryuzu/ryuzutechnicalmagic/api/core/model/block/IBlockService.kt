package dev.ryuzu.ryuzutechnicalmagic.api.core.model.block

import dev.ryuzu.ryuzutechnicalmagic.api.core.model.configuration.base.ConfiguredIntLocation

interface IBlockService {
    fun setBlock(location: ConfiguredIntLocation, block: String)
    fun getBlockState(location: ConfiguredIntLocation)
}