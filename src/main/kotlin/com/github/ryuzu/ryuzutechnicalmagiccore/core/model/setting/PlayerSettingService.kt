package com.github.ryuzu.ryuzutechnicalmagiccore.core.model.setting

import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.setting.PlayerDataEntity
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.setting.PlayerSettingEntity
import com.github.ryuzu.ryuzutechnicalmagiccore.core.repository.setting.PlayerDataRepository
import org.koin.core.annotation.Single
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import java.util.UUID
import kotlin.jvm.optionals.getOrNull

@Single
class PlayerSettingService : KoinComponent {
    private val playerDataRepository: PlayerDataRepository by inject()

    fun findOrCreatePlayerSetting(player: UUID): PlayerDataEntity =
        playerDataRepository.findById(player).getOrNull() ?: PlayerDataEntity(player)
}