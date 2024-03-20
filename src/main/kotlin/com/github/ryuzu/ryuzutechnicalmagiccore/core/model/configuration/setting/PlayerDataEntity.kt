package com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.setting

import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.player.IItem
import org.springframework.data.mongodb.core.mapping.Document
import java.util.*

@Document("playerdata")
data class PlayerDataEntity(
    val id: UUID,
    val inventory: List<IItem> = emptyList(),
    val enderChest: List<IItem> = emptyList(),
    val setting: PlayerSettingEntity = PlayerSettingEntity()
)
