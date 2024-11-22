package dev.ryuzu.ryuzutechnicalmagiccore.model.configuration.module

import com.charleskorn.kaml.decodeFromStream
import dev.ryuzu.ryuzutechnicalmagiccore.model.configuration.game.stage.ConfiguredStage
import dev.ryuzu.ryuzutechnicalmagiccore.model.configuration.reward.ConfiguredReward
import dev.ryuzu.ryuzutechnicalmagiccore.model.configuration.util.gui.ConfiguredGui
import org.koin.core.annotation.Module
import org.koin.core.annotation.Named
import org.koin.core.annotation.Single
import java.io.File
import java.io.InputStream

@Module
class ConfiguredRewardModule : AbstractConfigurationModule<Map<String, ConfiguredReward>, Map<String, ConfiguredReward>>() {
    override val folderName: String = "rewards"

    @Single(createdAtStart = true)
    @Named("RewardConfig")
    override fun loadConfig(): Map<String, ConfiguredReward> = super.loadConfig()

    override fun processStream(stream: InputStream): Map<String, ConfiguredReward> = kaml.decodeFromStream(stream)
}