package dev.ryuzu.ryuzutechnicalmagic.api.core.repository

import dev.ryuzu.ryuzutechnicalmagic.api.core.model.configuration.persistent.PlayerPersistentDataEntity
import org.springframework.data.mongodb.repository.MongoRepository
import java.util.UUID

interface IPlayerDataRepository : MongoRepository<PlayerPersistentDataEntity, UUID> {
}