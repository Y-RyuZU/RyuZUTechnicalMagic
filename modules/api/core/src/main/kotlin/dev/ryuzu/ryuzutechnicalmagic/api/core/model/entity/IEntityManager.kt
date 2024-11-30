package dev.ryuzu.ryuzutechnicalmagic.api.core.model.entity

import java.util.*

interface IEntityManager {
    fun getPlayer(id: UUID): dev.ryuzu.ryuzutechnicalmagic.api.core.model.entity.IPlayer
    fun setPlayer(player: dev.ryuzu.ryuzutechnicalmagic.api.core.model.entity.IPlayer)
    fun getEntity(id: UUID): IEntity
    fun getLivingEntity(id: UUID): ILivingEntity
}