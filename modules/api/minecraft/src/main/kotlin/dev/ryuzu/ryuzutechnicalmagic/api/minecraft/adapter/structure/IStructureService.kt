package dev.ryuzu.ryuzutechnicalmagic.api.minecraft.adapter.structure

import dev.ryuzu.ryuzutechnicalmagic.api.core.configuration.data.base.ConfiguredIntLocation
import dev.ryuzu.ryuzutechnicalmagic.api.core.model.scheduler.ISimpleScheduler

interface IStructureService {
    fun read(location: ConfiguredIntLocation, structure: String): ISimpleScheduler
    fun read(world: String, structure: String): ISimpleScheduler
    fun delete(world: String)
}