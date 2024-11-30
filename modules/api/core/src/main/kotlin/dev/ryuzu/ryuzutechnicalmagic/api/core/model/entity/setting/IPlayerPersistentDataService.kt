package dev.ryuzu.ryuzutechnicalmagic.api.core.model.entity.setting

import dev.ryuzu.ryuzutechnicalmagic.api.core.configuration.data.persistent.PlayerPersistentDataEntity
import dev.ryuzu.ryuzutechnicalmagic.api.core.model.entity.IPlayer

interface IPlayerPersistentDataService {
    fun getPersistentData(player: IPlayer): PlayerPersistentDataEntity
    fun start()
}