package dev.ryuzu.ryuzutechnicalmagic.api.minecraft.adapter.block

import dev.ryuzu.ryuzutechnicalmagic.api.core.model.configuration.base.ConfiguredIntLocation

interface IBlockAdapter {
    fun setBlock(location: ConfiguredIntLocation, block: String)
}