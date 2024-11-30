package dev.ryuzu.ryuzutechnicalmagic.minecraft.paper.implementation.util.wrapper.entity

import com.github.ryuzu.ryuzutechnicalmagiccore.core.util.wrapper.entity.IEntityService
import org.bukkit.Bukkit
import org.koin.core.annotation.Single
import java.util.*

@Single([IEntityService::class])
class EntityServiceImpl : IEntityService {
    override fun remove(entity: UUID) {
        Bukkit.getEntity(entity)?.remove()
    }
}