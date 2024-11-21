package dev.ryuzu.ryuzutechnicalmagiccore.model.configuration.module

import com.charleskorn.kaml.decodeFromStream
import dev.ryuzu.ryuzutechnicalmagiccore.model.configuration.game.anomaly.ConfiguredAnomaly
import dev.ryuzu.ryuzutechnicalmagiccore.model.configuration.game.mode.ConfiguredGameMode
import dev.ryuzu.ryuzutechnicalmagiccore.model.game.stage.anomaly.AnomalyType
import org.koin.core.annotation.Module
import org.koin.core.annotation.Named
import org.koin.core.annotation.Single
import java.io.File
import java.io.InputStream

@Module
class ConfiguredAnomalyModule :
    AbstractConfigurationModule<Map<AnomalyType, ConfiguredAnomaly>, Map<AnomalyType, ConfiguredAnomaly>>() {
    override val folderName: String = "anomalies"

    @Single(createdAtStart = true)
    @Named("AnomalyConfig")
    override fun loadConfig(): Map<AnomalyType, ConfiguredAnomaly> = super.loadConfig()

    override fun processStream(stream: InputStream): Map<AnomalyType, ConfiguredAnomaly> = kaml.decodeFromStream(stream)
}