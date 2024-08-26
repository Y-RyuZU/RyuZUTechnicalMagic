package com.github.ryuzu.ryuzutechnicalmagiccore.core.model.block

import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.base.ConfiguredIntLocation

interface IBlockService {
    fun setBlock(location: ConfiguredIntLocation, block: String)
    fun getBlockState(location: ConfiguredIntLocation)
}