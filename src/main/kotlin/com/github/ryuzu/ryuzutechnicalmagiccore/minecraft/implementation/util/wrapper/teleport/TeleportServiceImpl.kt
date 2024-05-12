package com.github.ryuzu.ryuzutechnicalmagiccore.minecraft.implementation.util.wrapper.teleport

import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.base.ConfiguredIntLocation
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.base.ConfiguredIntVector
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.entity.IEntity
import com.github.ryuzu.ryuzutechnicalmagiccore.core.util.wrapper.teleport.ITeleportService
import com.github.ryuzu.ryuzutechnicalmagiccore.minecraft.util.ConfiguredUtility.Companion.toBlockLocation
import com.github.ryuzu.ryuzutechnicalmagiccore.minecraft.util.ConfiguredUtility.Companion.toMiddleLocation
import com.github.ryuzu.ryuzutechnicalmagiccore.minecraft.util.EntityUtility.Companion.toEntity
import org.koin.core.annotation.Single
import org.koin.core.component.KoinComponent

@Single([ITeleportService::class])
class TeleportServiceImpl : ITeleportService, KoinComponent {
    override fun teleport(location: ConfiguredIntLocation, entities: Set<IEntity>) {
        entities.map { it.toEntity() }.forEach { it.teleport(location.toBlockLocation()) }
    }

    override fun teleport(vector: ConfiguredIntVector, entities: Set<IEntity>) {
        entities.map { it.toEntity() }.forEach { it.teleport(vector.toLocation(it.location.world.name).toMiddleLocation()) }
    }
}