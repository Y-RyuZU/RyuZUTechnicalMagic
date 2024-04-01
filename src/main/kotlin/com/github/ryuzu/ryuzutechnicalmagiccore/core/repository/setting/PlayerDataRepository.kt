package com.github.ryuzu.ryuzutechnicalmagiccore.core.repository.setting

import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.setting.PlayerPersistentDataEntity
import org.koin.core.annotation.Single
import org.springframework.data.mongodb.repository.MongoRepository
import java.util.UUID

interface PlayerDataRepository : MongoRepository<PlayerPersistentDataEntity, UUID> {
}