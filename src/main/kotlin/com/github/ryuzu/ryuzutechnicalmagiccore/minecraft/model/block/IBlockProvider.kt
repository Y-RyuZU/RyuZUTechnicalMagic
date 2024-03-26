package com.github.ryuzu.ryuzutechnicalmagiccore.minecraft.model.block

import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.base.ConfiguredIntLocation

interface IBlockProvider {
    fun setBlock(location: ConfiguredIntLocation, block: String)
}