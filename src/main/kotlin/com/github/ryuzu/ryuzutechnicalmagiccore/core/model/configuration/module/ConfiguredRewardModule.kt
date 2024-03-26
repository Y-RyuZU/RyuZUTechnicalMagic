package com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.module

import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.reward.ConfiguredReward
import org.koin.core.annotation.Module
import org.koin.core.annotation.Single
import java.io.File

@Module
class ConfiguredRewardModule : AbstractConfigurationModule<HashMap<String, ConfiguredReward>, ConfiguredReward>() {
    companion object {
        const val REWARDS_PATH = "rewards"
    }

    @Single
    override fun loadConfig(): HashMap<String, ConfiguredReward> = super.loadConfig()

    override fun processFile(file: File): ConfiguredReward {
        return mapper.readValue(File(file, REWARDS_PATH), ConfiguredReward::class.java)
    }
}