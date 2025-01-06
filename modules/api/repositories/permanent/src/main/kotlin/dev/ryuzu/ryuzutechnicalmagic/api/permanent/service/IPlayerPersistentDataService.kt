package dev.ryuzu.ryuzutechnicalmagic.api.permanent.service

import dev.ryuzu.ryuzutechnicalmagic.api.core.model.entity.IPlayer
import dev.ryuzu.ryuzutechnicalmagic.api.permanent.data.PlayerPersistentDataEntity

interface IPlayerPersistentDataService {
    fun getPersistentData(player: IPlayer): PlayerPersistentDataEntity
    fun start()
}