package dev.ryuzu.ryuzutechnicalmagic.api.core.model.entity

import java.util.*

interface IEntityManager {
    fun getPlayer(id: UUID): IPlayer
    fun setPlayer(player: IPlayer)
    fun getEntity(id: UUID): IEntity
    fun getLivingEntity(id: UUID): ILivingEntity
}