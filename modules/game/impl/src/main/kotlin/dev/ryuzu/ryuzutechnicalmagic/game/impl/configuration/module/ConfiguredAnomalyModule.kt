package dev.ryuzu.ryuzutechnicalmagic.game.impl.configuration.module

import com.charleskorn.kaml.decodeFromStream
import dev.ryuzu.ryuzutechnicalmagic.api.game.data.anomaly.SerAnomaly
import dev.ryuzu.ryuzutechnicalmagic.api.game.service.stage.anomaly.AnomalyType
import org.koin.core.annotation.Named
import org.koin.core.annotation.Single
import java.io.InputStream

@Module
class ConfiguredAnomalyModule :
    AbstractConfigurationModule<Map<AnomalyType, SerAnomaly>, Map<AnomalyType, SerAnomaly>>() {
    override val folderName: String = "anomalies"

    @Single(createdAtStart = true)
    @Named("AnomalyConfig")
    override fun loadConfig(): Map<AnomalyType, SerAnomaly> = super.loadConfig()

    override fun processStream(stream: InputStream): Map<AnomalyType, SerAnomaly> = kaml.decodeFromStream(stream)
}