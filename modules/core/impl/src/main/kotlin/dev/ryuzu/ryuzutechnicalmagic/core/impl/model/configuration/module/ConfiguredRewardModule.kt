package dev.ryuzu.ryuzutechnicalmagic.core.impl.model.configuration.module

import com.charleskorn.kaml.decodeFromStream
import dev.ryuzu.ryuzutechnicalmagic.api.core.model.configuration.reward.ConfiguredReward
import org.koin.core.annotation.Module
import org.koin.core.annotation.Named
import org.koin.core.annotation.Single
import java.io.InputStream

@Module
class ConfiguredRewardModule : AbstractConfigurationModule<Map<String, ConfiguredReward>, Map<String, ConfiguredReward>>() {
    override val folderName: String = "rewards"

    @Single(createdAtStart = true)
    @Named("RewardConfig")
    override fun loadConfig(): Map<String, ConfiguredReward> = super.loadConfig()

    override fun processStream(stream: InputStream): Map<String, ConfiguredReward> = kaml.decodeFromStream(stream)
}