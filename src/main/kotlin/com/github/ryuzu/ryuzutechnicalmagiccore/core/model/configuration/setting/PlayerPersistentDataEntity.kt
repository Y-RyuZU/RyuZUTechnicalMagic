package com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.setting

import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.storage.Item
import org.springframework.data.mongodb.core.mapping.Document
import java.util.*

@Document("playerdata")
data class PlayerPersistentDataEntity(
    val id: UUID,
    val inventory: List<Item> = emptyList(),
    val enderChest: List<Item> = emptyList(),
    val level: PlayerLevelEntity = PlayerLevelEntity(),
    val setting: PlayerSettingEntity = PlayerSettingEntity(),
    val donate: PlayerDonateEntity = PlayerDonateEntity()
)
