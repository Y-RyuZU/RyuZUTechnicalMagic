package dev.ryuzu.ryuzutechnicalmagic.api.minecraft.adapter.structure

import dev.ryuzu.ryuzutechnicalmagic.api.core.data.base.SerIntLocation
import dev.ryuzu.ryuzutechnicalmagic.api.core.model.scheduler.ISimpleScheduler

interface IStructureService {
    fun read(location: SerIntLocation, structure: String): ISimpleScheduler
    fun read(world: String, structure: String): ISimpleScheduler
    fun delete(world: String)
}