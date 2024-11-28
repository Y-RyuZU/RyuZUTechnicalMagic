package dev.ryuzu.ryuzutechnicalmagic.api.core.model.entity.setting

import dev.ryuzu.ryuzutechnicalmagic.api.core.model.configuration.persistent.PlayerPersistentDataEntity
import dev.ryuzu.ryuzutechnicalmagic.api.core.model.entity.IPlayer

interface IPlayerPersistentDataService {
    fun getPersistentData(player: IPlayer): PlayerPersistentDataEntity
    fun start()
}