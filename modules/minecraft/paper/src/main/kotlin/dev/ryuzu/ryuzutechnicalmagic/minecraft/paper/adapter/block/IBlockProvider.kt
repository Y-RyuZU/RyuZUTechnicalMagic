package dev.ryuzu.ryuzutechnicalmagic.minecraft.paper.adapter.block

import dev.ryuzu.ryuzutechnicalmagic.api.core.model.configuration.base.ConfiguredIntLocation


interface IBlockProvider {
    fun setBlock(location: ConfiguredIntLocation, block: String)
}