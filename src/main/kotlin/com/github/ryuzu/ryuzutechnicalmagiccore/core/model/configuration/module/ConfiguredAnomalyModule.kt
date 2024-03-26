package com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.module

import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.game.anomaly.ConfiguredAnomaly
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.game.stage.anomaly.AnomalyType
import org.koin.core.annotation.Module
import org.koin.core.annotation.Single
import java.io.File

@Module
class ConfiguredAnomalyModule :
    AbstractConfigurationModule<HashMap<AnomalyType, ConfiguredAnomaly>, ConfiguredAnomaly>() {
    companion object {
        private const val ANOMALY_PATH = "anomaly"
    }

    @Single
    override fun loadConfig(): HashMap<AnomalyType, ConfiguredAnomaly> = super.loadConfig()

    override fun processFile(file: File): ConfiguredAnomaly {
        return mapper.readValue(File(file, ANOMALY_PATH), ConfiguredAnomaly::class.java)
    }
}