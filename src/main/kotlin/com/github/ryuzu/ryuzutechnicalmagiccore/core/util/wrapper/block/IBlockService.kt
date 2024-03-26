package com.github.ryuzu.ryuzutechnicalmagiccore.core.util.wrapper.block

import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.base.ConfiguredIntLocation
import org.koin.core.component.KoinComponent

interface IBlockService : KoinComponent {
    fun setBlock(location: ConfiguredIntLocation, block: String)
}