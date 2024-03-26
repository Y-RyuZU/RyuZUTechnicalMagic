package com.github.ryuzu.ryuzutechnicalmagiccore.minecraft.implementation.util.wrapper.entity

import com.github.ryuzu.ryuzutechnicalmagiccore.core.util.wrapper.entity.IEntityService
import org.bukkit.Bukkit
import java.util.*

class EntityServiceImpl : IEntityService {
    override fun remove(entity: UUID) {
        Bukkit.getEntity(entity)?.remove()
    }
}