package dev.ryuzu.ryuzutechnicalmagiccore.adapter.block

import dev.ryuzu.ryuzutechnicalmagiccore.model.configuration.base.ConfiguredIntLocation

interface IBlockAdapter {
    fun setBlock(location: ConfiguredIntLocation, block: String)
}