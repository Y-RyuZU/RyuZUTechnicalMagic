package com.github.ryuzu.ryuzutechnicalmagiccore.core.model.entity.setting

import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.persistent.PlayerPersistentDataEntity
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.entity.IPlayer
import org.koin.core.component.KoinComponent

interface IPlayerPersistentDataService : KoinComponent {
    fun getPersistentData(player: IPlayer): PlayerPersistentDataEntity
    fun start()
}