package dev.ryuzu.ryuzutechnicalmagiccore.model.configuration.persistent

import org.springframework.data.mongodb.core.mapping.Document
import java.util.*

@Document("playerdata")
data class PlayerPersistentDataEntity(
    val id: UUID,
    val vault: dev.ryuzu.ryuzutechnicalmagiccore.model.configuration.persistent.PlayerVaultEntity = dev.ryuzu.ryuzutechnicalmagiccore.model.configuration.persistent.PlayerVaultEntity(),
    val level: PlayerLevelEntity = PlayerLevelEntity(),
    val setting: PlayerSettingEntity = PlayerSettingEntity(),
    val donate: PlayerDonateEntity = PlayerDonateEntity(),
)
