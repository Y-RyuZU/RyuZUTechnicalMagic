package dev.ryuzu.ryuzutechnicalmagic.core.impl.model.configuration.module

import com.charleskorn.kaml.decodeFromStream
import dev.ryuzu.ryuzutechnicalmagic.api.core.data.database.SerMongoConnectionInfo
import org.koin.core.annotation.Module
import org.koin.core.annotation.Single
import java.io.InputStream

@Module
class ConfiguredMongoConnectionInfoModule : AbstractConfigurationModule<SerMongoConnectionInfo, SerMongoConnectionInfo>() {
    override val fileName: String = "mongo"

    @Single
    override fun loadConfig(): SerMongoConnectionInfo = super.loadConfig()

    override fun processStream(stream: InputStream): SerMongoConnectionInfo = kaml.decodeFromStream(stream)
}