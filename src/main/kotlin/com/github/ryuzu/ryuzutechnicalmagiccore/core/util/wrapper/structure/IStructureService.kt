package com.github.ryuzu.ryuzutechnicalmagiccore.core.util.wrapper.structure

import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.base.ConfiguredIntLocation
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.scheduler.ISimpleScheduler
import org.koin.core.component.KoinComponent

interface IStructureService : KoinComponent {
    fun read(location: ConfiguredIntLocation, structure: String): ISimpleScheduler
    fun read(world: String, structure: String): ISimpleScheduler
    fun delete(world: String)
}