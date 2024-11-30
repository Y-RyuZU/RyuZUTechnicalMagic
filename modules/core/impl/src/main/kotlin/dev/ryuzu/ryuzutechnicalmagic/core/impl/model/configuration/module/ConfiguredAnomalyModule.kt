package dev.ryuzu.ryuzutechnicalmagic.core.impl.model.configuration.module

import com.charleskorn.kaml.decodeFromStream
import dev.ryuzu.ryuzutechnicalmagic.api.core.configuration.data.game.anomaly.ConfiguredAnomaly
import org.koin.core.annotation.Module
import org.koin.core.annotation.Named
import org.koin.core.annotation.Single
import java.io.InputStream

@Module
class ConfiguredAnomalyModule :
    AbstractConfigurationModule<Map<dev.ryuzu.ryuzutechnicalmagic.api.core.model.game.stage.anomaly.AnomalyType, dev.ryuzu.ryuzutechnicalmagic.api.core.configuration.data.game.anomaly.ConfiguredAnomaly>, Map<dev.ryuzu.ryuzutechnicalmagic.api.core.model.game.stage.anomaly.AnomalyType, dev.ryuzu.ryuzutechnicalmagic.api.core.configuration.data.game.anomaly.ConfiguredAnomaly>>() {
    override val folderName: String = "anomalies"

    @Single(createdAtStart = true)
    @Named("AnomalyConfig")
    override fun loadConfig(): Map<dev.ryuzu.ryuzutechnicalmagic.api.core.model.game.stage.anomaly.AnomalyType, dev.ryuzu.ryuzutechnicalmagic.api.core.configuration.data.game.anomaly.ConfiguredAnomaly> = super.loadConfig()

    override fun processStream(stream: InputStream): Map<dev.ryuzu.ryuzutechnicalmagic.api.core.model.game.stage.anomaly.AnomalyType, dev.ryuzu.ryuzutechnicalmagic.api.core.configuration.data.game.anomaly.ConfiguredAnomaly> = kaml.decodeFromStream(stream)
}