package dev.ryuzu.ryuzutechnicalmagiccore.repository

import dev.ryuzu.ryuzutechnicalmagiccore.model.configuration.persistent.PlayerPersistentDataEntity
import org.springframework.data.mongodb.repository.MongoRepository
import java.util.UUID

interface PlayerDataRepository : MongoRepository<PlayerPersistentDataEntity, UUID> {
}