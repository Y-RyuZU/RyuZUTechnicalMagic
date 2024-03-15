package com.github.ryuzu.ryuzutechnicalmagiccore.core.model.player

import org.springframework.data.mongodb.core.mapping.Document
import java.util.*

@Document("playerdata")
data class PlayerData(
    val id: UUID,
    val inventory: List<IItem>,
    val enderChest: List<IItem>,
    val settings: List<IPlayerSetting>
)
