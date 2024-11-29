package dev.ryuzu.ryuzutechnicalmagic.api.core.configuration.persistent

//import org.springframework.data.mongodb.core.mapping.Document
import java.util.*

//@Document("playerdata")
data class PlayerPersistentDataEntity(
    val id: UUID,
    val vault: dev.ryuzu.ryuzutechnicalmagic.api.core.configuration.persistent.PlayerVaultEntity = dev.ryuzu.ryuzutechnicalmagic.api.core.configuration.persistent.PlayerVaultEntity(),
    val level: PlayerLevelEntity = PlayerLevelEntity(),
    val setting: PlayerSettingEntity = PlayerSettingEntity(),
    val donate: PlayerDonateEntity = PlayerDonateEntity(),
)
