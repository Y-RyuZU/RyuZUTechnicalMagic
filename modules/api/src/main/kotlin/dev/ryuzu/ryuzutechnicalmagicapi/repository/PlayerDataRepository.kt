package dev.ryuzu.ryuzutechnicalmagicapi.repository

import dev.ryuzu.ryuzutechnicalmagicapi.model.configuration.persistent.PlayerPersistentDataEntity
import org.springframework.data.mongodb.repository.MongoRepository
import java.util.UUID

interface PlayerDataRepository : MongoRepository<PlayerPersistentDataEntity, UUID> {
}