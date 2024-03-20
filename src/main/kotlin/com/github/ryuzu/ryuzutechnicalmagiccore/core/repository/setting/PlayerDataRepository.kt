package com.github.ryuzu.ryuzutechnicalmagiccore.core.repository.setting

import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.setting.PlayerDataEntity
import org.koin.core.annotation.Single
import org.springframework.data.mongodb.repository.MongoRepository
import java.util.UUID

@Single
interface PlayerDataRepository : MongoRepository<PlayerDataEntity, UUID> {
}