package dev.ryuzu.ryuzutechnicalmagic.minecraft.paper.util

import dev.ryuzu.ryuzutechnicalmagic.api.core.model.entity.IEntity
import dev.ryuzu.ryuzutechnicalmagic.api.core.model.entity.ILivingEntity
import dev.ryuzu.ryuzutechnicalmagic.api.core.model.entity.IPlayer
import org.bukkit.Bukkit
import org.bukkit.entity.Entity
import org.bukkit.entity.LivingEntity
import org.bukkit.entity.Player
import java.util.*

class EntityUtility {
    companion object {
        fun UUID.toPlayer(): Player {
            return Bukkit.getPlayer(this)!!
        }

        fun UUID.toLivingEntity(): LivingEntity {
            return (Bukkit.getEntity(this) as LivingEntity?)!!
        }

        fun UUID.toEntity(): Entity {
            return Bukkit.getEntity(this)!!
        }

        fun IPlayer.toPlayer(): Player {
            return Bukkit.getPlayer(this.id)!!
        }

        fun ILivingEntity.toLivingEntity(): LivingEntity {
            return (Bukkit.getEntity(this.id) as LivingEntity?)!!
        }

        fun IEntity.toEntity(): Entity {
            return Bukkit.getEntity(this.id)!!
        }
    }
}