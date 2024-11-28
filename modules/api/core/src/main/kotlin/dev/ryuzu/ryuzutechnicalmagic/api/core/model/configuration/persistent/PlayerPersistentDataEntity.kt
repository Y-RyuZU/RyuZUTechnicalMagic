package dev.ryuzu.ryuzutechnicalmagic.api.core.model.configuration.persistent

//import org.springframework.data.mongodb.core.mapping.Document
import java.util.*

//@Document("playerdata")
data class PlayerPersistentDataEntity(
    val id: UUID,
    val vault: PlayerVaultEntity = PlayerVaultEntity(),
    val level: PlayerLevelEntity = PlayerLevelEntity(),
    val setting: dev.ryuzu.ryuzutechnicalmagic.api.core.model.configuration.persistent.PlayerSettingEntity = dev.ryuzu.ryuzutechnicalmagic.api.core.model.configuration.persistent.PlayerSettingEntity(),
    val donate: PlayerDonateEntity = PlayerDonateEntity(),
)
