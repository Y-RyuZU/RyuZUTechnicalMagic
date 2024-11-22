package dev.ryuzu.ryuzutechnicalmagicapi.util.wrapper.structure

import dev.ryuzu.ryuzutechnicalmagicapi.model.configuration.base.ConfiguredIntLocation
import dev.ryuzu.ryuzutechnicalmagicapi.model.scheduler.ISimpleScheduler

interface IStructureService {
    fun read(location: ConfiguredIntLocation, structure: String): ISimpleScheduler
    fun read(world: String, structure: String): ISimpleScheduler
    fun delete(world: String)
}