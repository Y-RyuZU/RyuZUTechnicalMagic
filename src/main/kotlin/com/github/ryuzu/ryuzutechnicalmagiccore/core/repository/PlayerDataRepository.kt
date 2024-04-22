package com.github.ryuzu.ryuzutechnicalmagiccore.core.repository

import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.persistent.PlayerPersistentDataEntity
import org.springframework.data.mongodb.repository.MongoRepository
import java.util.UUID

interface PlayerDataRepository : MongoRepository<PlayerPersistentDataEntity, UUID> {
}