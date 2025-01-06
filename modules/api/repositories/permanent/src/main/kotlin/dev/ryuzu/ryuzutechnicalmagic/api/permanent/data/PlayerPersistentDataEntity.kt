package dev.ryuzu.ryuzutechnicalmagic.api.permanent.data

//import org.springframework.data.mongodb.core.mapping.Document
import java.util.*

//@Document("playerdata")
data class PlayerPersistentDataEntity(
    val id: UUID,
    val vault: PlayerVaultEntity = PlayerVaultEntity(),
    val level: PlayerLevelEntity = PlayerLevelEntity(),
    val setting: PlayerSettingEntity = PlayerSettingEntity(),
    val donate: PlayerDonateEntity = PlayerDonateEntity(),
)
