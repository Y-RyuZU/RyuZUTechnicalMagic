package com.github.ryuzu.ryuzutechnicalmagiccore.core.repository.storage

import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.player.PlayerData
import org.springframework.data.mongodb.repository.MongoRepository
import java.util.UUID

interface PlayerDataRepository : MongoRepository<PlayerData, UUID> {
}