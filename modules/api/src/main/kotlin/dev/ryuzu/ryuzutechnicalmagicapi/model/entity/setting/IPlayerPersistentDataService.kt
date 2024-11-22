package dev.ryuzu.ryuzutechnicalmagicapi.model.entity.setting

import dev.ryuzu.ryuzutechnicalmagicapi.model.configuration.persistent.PlayerPersistentDataEntity
import dev.ryuzu.ryuzutechnicalmagicapi.model.entity.IPlayer

interface IPlayerPersistentDataService {
    fun getPersistentData(player: IPlayer): PlayerPersistentDataEntity
    fun start()
}