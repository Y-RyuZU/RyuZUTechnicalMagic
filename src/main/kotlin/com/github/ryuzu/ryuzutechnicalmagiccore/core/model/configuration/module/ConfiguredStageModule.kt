package com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.module

import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.game.stage.ConfiguredStage
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.util.gui.ConfiguredGui
import org.koin.core.annotation.Module
import org.koin.core.annotation.Named
import org.koin.core.annotation.Single
import java.io.File

@Module
class ConfiguredStageModule :
    AbstractConfigurationModule<Map<String, ConfiguredStage>, Map<String, ConfiguredStage>>() {
    override val folderName: String = "stages"

    @Single(createdAtStart = true)
    @Named("StageConfig")
    override fun loadConfig(): Map<String, ConfiguredStage> = super.loadConfig()

    override fun processFile(file: File): Map<String, ConfiguredStage> {
        val mapType = mapper.typeFactory
            .constructMapType(Map::class.java, String::class.java, ConfiguredStage::class.java)
        return mapper.readValue(file, mapType)
    }
}