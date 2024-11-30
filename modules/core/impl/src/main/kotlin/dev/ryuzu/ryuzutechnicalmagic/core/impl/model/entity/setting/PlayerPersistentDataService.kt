package dev.ryuzu.ryuzutechnicalmagic.core.impl.model.entity.setting

import dev.ryuzu.ryuzutechnicalmagic.api.core.model.configuration.general.ConfiguredGeneralParameter
import dev.ryuzu.ryuzutechnicalmagic.api.core.model.configuration.persistent.PlayerPersistentDataEntity
import dev.ryuzu.ryuzutechnicalmagic.api.core.model.entity.IPlayer
import dev.ryuzu.ryuzutechnicalmagic.api.core.model.entity.setting.IPlayerPersistentDataService
import dev.ryuzu.ryuzutechnicalmagic.api.core.model.scheduler.UpdatePeriod
import dev.ryuzu.ryuzutechnicalmagic.api.core.repository.IPlayerDataRepository
import dev.ryuzu.ryuzutechnicalmagic.core.impl.model.scheduler.SimpleSchedulerFactory
import org.koin.core.annotation.Single
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import java.util.*
import kotlin.jvm.optionals.getOrNull

@Single([IPlayerPersistentDataService::class])
class PlayerPersistentDataService : IPlayerPersistentDataService, KoinComponent {
    private val playerDataRepository: IPlayerDataRepository by inject()
    private val schedulerFactory: SimpleSchedulerFactory by inject()
    private val generalParameter: ConfiguredGeneralParameter by inject()
    private val playerDataCache: MutableMap<UUID, PlayerPersistentDataEntity> = mutableMapOf()

    override fun getPersistentData(player: IPlayer): PlayerPersistentDataEntity =
        playerDataCache[player.id] ?: throw IllegalArgumentException("Player('${player.id}') setting not found")

    override fun start() {
        schedulerFactory.createSimpleScheduler(UpdatePeriod.MINUTE).whileSchedule({ count -> count % generalParameter.autoSavingParameter.persistentSaveInterval == 0.toLong() }) { _, _ ->
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