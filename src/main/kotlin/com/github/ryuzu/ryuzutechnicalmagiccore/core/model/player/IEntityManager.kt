package com.github.ryuzu.ryuzutechnicalmagiccore.core.model.player

import java.util.UUID

interface IEntityManager {
    fun getPlayer(id: UUID): IPlayer
    fun setPlayer(player: IPlayer)
    fun getEntity(id: UUID): IEntity
    fun getLivingEntity(id: UUID): ILivingEntity
}