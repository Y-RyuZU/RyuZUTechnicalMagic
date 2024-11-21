package dev.ryuzu.ryuzutechnicalmagiccore.util.wrapper.structure

import dev.ryuzu.ryuzutechnicalmagiccore.model.configuration.base.ConfiguredIntLocation
import dev.ryuzu.ryuzutechnicalmagiccore.model.scheduler.ISimpleScheduler
import org.koin.core.component.KoinComponent

interface IStructureService : KoinComponent {
    fun read(location: ConfiguredIntLocation, structure: String): ISimpleScheduler
    fun read(world: String, structure: String): ISimpleScheduler
    fun delete(world: String)
}