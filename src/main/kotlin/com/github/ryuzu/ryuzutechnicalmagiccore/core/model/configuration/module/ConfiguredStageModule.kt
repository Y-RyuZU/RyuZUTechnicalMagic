package com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.module

import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.game.stage.ConfiguredStage
import org.koin.core.annotation.Module
import org.koin.core.annotation.Single
import java.io.File

@Module
class ConfiguredStageModule :
    AbstractConfigurationModule<HashMap<String, ConfiguredStage>, ConfiguredStage>() {
    companion object {
        private const val STAGES_PATH = "stages"
    }

    @Single
    override fun loadConfig(): HashMap<String, ConfiguredStage> = super.loadConfig()

    override fun processFile(file: File): ConfiguredStage {
        return mapper.readValue(File(file, STAGES_PATH), ConfiguredStage::class.java)
    }
}