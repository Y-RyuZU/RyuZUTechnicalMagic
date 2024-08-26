package com.github.ryuzu.ryuzutechnicalmagiccore.core.adapter.block

import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.base.ConfiguredIntLocation

interface IBlockAdapter {
    fun setBlock(location: ConfiguredIntLocation, block: String)
}