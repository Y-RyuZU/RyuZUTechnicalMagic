package dev.ryuzu.ryuzutechnicalmagiccore.model.entity.setting

import dev.ryuzu.ryuzutechnicalmagiccore.model.configuration.persistent.PlayerPersistentDataEntity
import dev.ryuzu.ryuzutechnicalmagiccore.model.entity.IPlayer
import org.koin.core.component.KoinComponent

interface IPlayerPersistentDataService : KoinComponent {
    fun getPersistentData(player: IPlayer): PlayerPersistentDataEntity
    fun start()
}