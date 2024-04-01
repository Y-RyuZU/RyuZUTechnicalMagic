package com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.module

import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.game.anomaly.ConfiguredAnomaly
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.game.mode.ConfiguredGameMode
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.game.stage.anomaly.AnomalyType
import org.koin.core.annotation.Module
import org.koin.core.annotation.Named
import org.koin.core.annotation.Single
import java.io.File

@Module
class ConfiguredAnomalyModule :
    AbstractConfigurationModule<Map<AnomalyType, ConfiguredAnomaly>, Map<AnomalyType, ConfiguredAnomaly>>() {
    override val folderName: String = "anomalies"

    @Single(createdAtStart = true)
    @Named("AnomalyConfig")
    override fun loadConfig(): Map<AnomalyType, ConfiguredAnomaly> = super.loadConfig()

    override fun processFile(file: File): Map<AnomalyType, ConfiguredAnomaly> {
        val mapType = mapper.typeFactory
            .constructMapType(Map::class.java, AnomalyType::class.java, ConfiguredAnomaly::class.java)
        return mapper.readValue(file, mapType)
    }
}