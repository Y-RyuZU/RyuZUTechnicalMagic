package com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.module

import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.reward.ConfiguredReward
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.util.gui.ConfiguredGui
import org.koin.core.annotation.Module
import org.koin.core.annotation.Named
import org.koin.core.annotation.Single
import java.io.File

@Module
class ConfiguredRewardModule : AbstractConfigurationModule<Map<String, ConfiguredReward>, Map<String, ConfiguredReward>>() {
    override val folderName: String = "rewards"

    @Single(createdAtStart = true)
    @Named("RewardConfig")
    override fun loadConfig(): Map<String, ConfiguredReward> = super.loadConfig()

    override fun processFile(file: File): Map<String, ConfiguredReward> {
        val mapType = mapper.typeFactory
            .constructMapType(Map::class.java, String::class.java, ConfiguredReward::class.java)
        return mapper.readValue(file, mapType)
    }
}