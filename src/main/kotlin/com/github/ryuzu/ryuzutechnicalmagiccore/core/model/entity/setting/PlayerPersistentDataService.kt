package com.github.ryuzu.ryuzutechnicalmagiccore.core.model.entity.setting

import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.general.ConfiguredGeneralParameter
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.persistent.PlayerPersistentDataEntity
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.entity.IPlayer
import com.github.ryuzu.ryuzutechnicalmagiccore.core.repository.PlayerDataRepository
import com.github.ryuzu.ryuzutechnicalmagiccore.core.util.scheduler.SimpleSchedulerFactory
import com.github.ryuzu.ryuzutechnicalmagiccore.core.util.scheduler.UpdatePeriod
import org.koin.core.annotation.Single
import org.koin.core.component.inject
import java.util.UUID
import kotlin.jvm.optionals.getOrNull

@Single([IPlayerPersistentDataService::class])
class PlayerPersistentDataService : IPlayerPersistentDataService {
    private val playerDataRepository: PlayerDataRepository by inject()
    private val schedulerFactory: SimpleSchedulerFactory by inject()
    private val generalParameter: ConfiguredGeneralParameter by inject()
    private val playerDataCache: MutableMap<UUID, PlayerPersistentDataEntity> = mutableMapOf()

    override fun getPersistentData(player: IPlayer): PlayerPersistentDataEntity =
        playerDataCache[player.id] ?: throw IllegalArgumentException("Player('${player.id}') setting not found")

    override fun start() {
        schedulerFactory.createScheduler(UpdatePeriod.MINUTE).whileSchedule({ count -> count % generalParameter.autoSavingParameter.persistentSaveInterval == 0.toLong() }) { _, _ ->
            saveAll()
        }.runAsync()
    }

    private fun readOrCreatePlayerSetting(player: IPlayer) {
        playerDataCache[player.id] = findOrCreatePlayerSetting(player.id)
    }

    private fun saveAll() {
        playerDataRepository.saveAll(playerDataCache.values)
    }

    private fun findOrCreatePlayerSetting(player: UUID): PlayerPersistentDataEntity =
        playerDataRepository.findById(player).getOrNull() ?: PlayerPersistentDataEntity(player)
}