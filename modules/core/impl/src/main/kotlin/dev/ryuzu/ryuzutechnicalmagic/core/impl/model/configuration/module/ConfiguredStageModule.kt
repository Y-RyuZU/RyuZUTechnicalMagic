package dev.ryuzu.ryuzutechnicalmagic.core.impl.model.configuration.module

import com.charleskorn.kaml.decodeFromStream
import dev.ryuzu.ryuzutechnicalmagic.api.core.model.configuration.game.stage.ConfiguredStage
import org.koin.core.annotation.Module
import org.koin.core.annotation.Named
import org.koin.core.annotation.Single
import java.io.InputStream

@Module
class ConfiguredStageModule :
    AbstractConfigurationModule<Map<String, ConfiguredStage>, Map<String, ConfiguredStage>>() {
    override val folderName: String = "stages"

    @Single(createdAtStart = true)
    @Named("StageConfig")
    override fun loadConfig(): Map<String, ConfiguredStage> = super.loadConfig()

    override fun processStream(stream: InputStream): Map<String, ConfiguredStage> = kaml.decodeFromStream(stream)
}