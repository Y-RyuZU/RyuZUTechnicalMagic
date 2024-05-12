package com.github.ryuzu.ryuzutechnicalmagiccore.minecraft.implementation.player

import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.entity.*
import org.bukkit.Bukkit
import org.koin.core.annotation.Single
import java.util.*

@Single([IEntityManager::class])
class EntityManager : IEntityManager {
    private val entities: MutableMap<UUID, IEntity> = mutableMapOf()

    private fun getEntityInstance(id: UUID): IEntity {
        val entity = Bukkit.getEntity(id)
        return when (entity) {
            is org.bukkit.entity.Player -> {
                Player(LivingEntity(Entity(id)))
            }

            is org.bukkit.entity.LivingEntity -> {
                LivingEntity(Entity(id))
            }

            else -> {
                Entity(id)
            }
        }
    }

    override fun getPlayer(id: UUID): IPlayer = entities.getOrPut(id) { getEntityInstance(id) } as IPlayer

    override fun setPlayer(player: IPlayer) {
        entities[player.id] = player
    }

    override fun getLivingEntity(id: UUID): ILivingEntity = entities.getOrPut(id) { getEntityInstance(id) } as ILivingEntity

    override fun getEntity(id: UUID): IEntity = entities.getOrPut(id) { getEntityInstance(id) }
}