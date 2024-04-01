package com.github.ryuzu.ryuzutechnicalmagiccore.core.model.player.setting

import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.setting.PlayerPersistentDataEntity
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.game.IGameManager
import com.github.ryuzu.ryuzutechnicalmagiccore.core.repository.setting.PlayerDataRepository
import com.github.ryuzu.ryuzutechnicalmagiccore.core.util.scheduler.SimpleSchedulerFactory
import org.koin.core.annotation.Single
import org.koin.core.component.inject
import java.util.UUID
import kotlin.jvm.optionals.getOrNull

@Single([IPlayerPersistentDataService::class])
class PlayerPersistentDataService : IPlayerPersistentDataService {
    private val playerDataRepository: PlayerDataRepository by inject()
    private val schedulerFactory: SimpleSchedulerFactory by inject()
    private val playerDataCache: MutableMap<UUID, PlayerPersistentDataEntity> = mutableMapOf()

    override fun getPlayerSetting(player: UUID): PlayerPersistentDataEntity =
        playerDataCache[player] ?: throw IllegalArgumentException("Player setting not found")

    override fun start() {
        schedulerFactory.createScheduler().whileSchedule({ count -> count % (20 * 60 * 30) == 0.toLong() }) { _, _ ->
            saveAll()
        }.runAsync()
    }

    private fun readOrCreatePlayerSetting(player: UUID) {
        playerDataCache[player] = findOrCreatePlayerSetting(player)
    }

    private fun saveAll() {
        playerDataRepository.saveAll(playerDataCache.values)
    }

    private fun findOrCreatePlayerSetting(player: UUID): PlayerPersistentDataEntity =
        playerDataRepository.findById(player).getOrNull() ?: PlayerPersistentDataEntity(player)
}