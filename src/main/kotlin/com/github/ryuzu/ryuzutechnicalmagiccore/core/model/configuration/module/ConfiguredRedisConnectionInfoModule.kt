package com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.module

import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.database.ConfiguredMongoConnectionInfo
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.database.ConfiguredRedisConnectionInfo
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.game.entry.ConfiguredEntry
import org.koin.core.annotation.Module
import org.koin.core.annotation.Single
import java.io.File

@Module
class ConfiguredRedisConnectionInfoModule : AbstractConfigurationModule<ConfiguredRedisConnectionInfo, ConfiguredRedisConnectionInfo>() {
    override val fileName: String = "redis"

    @Single
    override fun loadConfig(): ConfiguredRedisConnectionInfo = super.loadConfig()

    override fun processFile(file: File): ConfiguredRedisConnectionInfo {
        return mapper.readValue(file, ConfiguredRedisConnectionInfo::class.java)
    }
}