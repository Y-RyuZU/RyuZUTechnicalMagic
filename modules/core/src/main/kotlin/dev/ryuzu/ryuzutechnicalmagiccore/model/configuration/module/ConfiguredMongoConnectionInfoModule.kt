package dev.ryuzu.ryuzutechnicalmagiccore.model.configuration.module

import com.charleskorn.kaml.decodeFromStream
import dev.ryuzu.ryuzutechnicalmagiccore.model.configuration.database.ConfiguredMongoConnectionInfo
import dev.ryuzu.ryuzutechnicalmagiccore.model.configuration.game.entry.ConfiguredEntry
import dev.ryuzu.ryuzutechnicalmagiccore.model.configuration.util.gui.ConfiguredGui
import org.koin.core.annotation.Module
import org.koin.core.annotation.Single
import java.io.File
import java.io.InputStream

@Module
class ConfiguredMongoConnectionInfoModule : AbstractConfigurationModule<ConfiguredMongoConnectionInfo, ConfiguredMongoConnectionInfo>() {
    override val fileName: String = "mongo"

    @Single
    override fun loadConfig(): ConfiguredMongoConnectionInfo = super.loadConfig()

    override fun processStream(stream: InputStream): ConfiguredMongoConnectionInfo = kaml.decodeFromStream(stream)
}