package dev.ryuzu.ryuzutechnicalmagic.core.impl.model.configuration.module

import com.charleskorn.kaml.decodeFromStream
import dev.ryuzu.ryuzutechnicalmagic.api.core.model.configuration.database.ConfiguredMongoConnectionInfo
import org.koin.core.annotation.Module
import org.koin.core.annotation.Single
import java.io.InputStream

@Module
class ConfiguredMongoConnectionInfoModule : AbstractConfigurationModule<ConfiguredMongoConnectionInfo, ConfiguredMongoConnectionInfo>() {
    override val fileName: String = "mongo"

    @Single
    override fun loadConfig(): ConfiguredMongoConnectionInfo = super.loadConfig()

    override fun processStream(stream: InputStream): ConfiguredMongoConnectionInfo = kaml.decodeFromStream(stream)
}