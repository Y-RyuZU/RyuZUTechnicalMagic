package com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.module

import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.database.ConfiguredMongoConnectionInfo
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.game.entry.ConfiguredEntry
import org.koin.core.annotation.Module
import org.koin.core.annotation.Single
import java.io.File

@Module
class ConfiguredMongoConnectionInfoModule : AbstractConfigurationModule<ConfiguredMongoConnectionInfo, ConfiguredMongoConnectionInfo>() {
    override val fileName: String = "mongo"

    @Single
    override fun loadConfig(): ConfiguredMongoConnectionInfo = super.loadConfig()

    override fun processFile(file: File): ConfiguredMongoConnectionInfo {
        return mapper.readValue(file, ConfiguredMongoConnectionInfo::class.java)
    }
}