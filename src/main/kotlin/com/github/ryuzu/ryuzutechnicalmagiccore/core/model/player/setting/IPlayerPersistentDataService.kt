package com.github.ryuzu.ryuzutechnicalmagiccore.core.model.player.setting

import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.setting.PlayerPersistentDataEntity
import org.koin.core.component.KoinComponent
import java.util.*

interface IPlayerPersistentDataService : KoinComponent {
    fun getPlayerSetting(player: UUID): PlayerPersistentDataEntity
    fun start()
}