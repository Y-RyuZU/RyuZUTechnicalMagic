package dev.ryuzu.ryuzutechnicalmagic.core.impl.model.configuration.module

import com.charleskorn.kaml.decodeFromStream
import dev.ryuzu.ryuzutechnicalmagic.api.core.model.configuration.database.ConfiguredRedisConnectionInfo
import org.koin.core.annotation.Module
import org.koin.core.annotation.Single
import java.io.InputStream

@Module
class ConfiguredRedisConnectionInfoModule : AbstractConfigurationModule<ConfiguredRedisConnectionInfo, ConfiguredRedisConnectionInfo>() {
    override val fileName: String = "redis"

    @Single
    override fun loadConfig(): ConfiguredRedisConnectionInfo = super.loadConfig()

    override fun processStream(stream: InputStream): ConfiguredRedisConnectionInfo = kaml.decodeFromStream(stream)
}