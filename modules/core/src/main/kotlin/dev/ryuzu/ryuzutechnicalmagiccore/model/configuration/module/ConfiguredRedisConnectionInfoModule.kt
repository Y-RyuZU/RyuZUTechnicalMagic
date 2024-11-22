package dev.ryuzu.ryuzutechnicalmagiccore.model.configuration.module

import com.charleskorn.kaml.decodeFromStream
import dev.ryuzu.ryuzutechnicalmagiccore.model.configuration.database.ConfiguredMongoConnectionInfo
import dev.ryuzu.ryuzutechnicalmagiccore.model.configuration.database.ConfiguredRedisConnectionInfo
import dev.ryuzu.ryuzutechnicalmagiccore.model.configuration.game.entry.ConfiguredEntry
import dev.ryuzu.ryuzutechnicalmagiccore.model.configuration.game.stage.ConfiguredStage
import org.koin.core.annotation.Module
import org.koin.core.annotation.Single
import java.io.File
import java.io.InputStream

@Module
class ConfiguredRedisConnectionInfoModule : AbstractConfigurationModule<ConfiguredRedisConnectionInfo, ConfiguredRedisConnectionInfo>() {
    override val fileName: String = "redis"

    @Single
    override fun loadConfig(): ConfiguredRedisConnectionInfo = super.loadConfig()

    override fun processStream(stream: InputStream): ConfiguredRedisConnectionInfo = kaml.decodeFromStream(stream)
}