package dev.ryuzu.ryuzutechnicalmagicapi.adapter.block

import dev.ryuzu.ryuzutechnicalmagicapi.model.configuration.base.ConfiguredIntLocation

interface IBlockAdapter {
    fun setBlock(location: ConfiguredIntLocation, block: String)
}