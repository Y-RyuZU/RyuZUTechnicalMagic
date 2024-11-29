package dev.ryuzu.ryuzutechnicalmagic.core.impl.model.configuration.module

import com.charleskorn.kaml.decodeFromStream
import dev.ryuzu.ryuzutechnicalmagic.api.core.configuration.database.ConfiguredMongoConnectionInfo
import org.koin.core.annotation.Module
import org.koin.core.annotation.Single
import java.io.InputStream

@Module
class ConfiguredMongoConnectionInfoModule : AbstractConfigurationModule<dev.ryuzu.ryuzutechnicalmagic.api.core.configuration.database.ConfiguredMongoConnectionInfo, dev.ryuzu.ryuzutechnicalmagic.api.core.configuration.database.ConfiguredMongoConnectionInfo>() {
    override val fileName: String = "mongo"

    @Single
    override fun loadConfig(): dev.ryuzu.ryuzutechnicalmagic.api.core.configuration.database.ConfiguredMongoConnectionInfo = super.loadConfig()

    override fun processStream(stream: InputStream): dev.ryuzu.ryuzutechnicalmagic.api.core.configuration.database.ConfiguredMongoConnectionInfo = kaml.decodeFromStream(stream)
}