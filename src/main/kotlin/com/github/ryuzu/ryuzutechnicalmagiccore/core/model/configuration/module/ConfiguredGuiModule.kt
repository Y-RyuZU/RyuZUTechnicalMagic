package com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.module

import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.util.gui.ConfiguredGui
import org.koin.core.annotation.Module
import org.koin.core.annotation.Named
import org.koin.core.annotation.Single
import java.io.File

@Module
class ConfiguredGuiModule :
    AbstractConfigurationModule<Map<String, ConfiguredGui>, Map<String, ConfiguredGui>>() {
    override val folderName: String = "guis"

    @Single(createdAtStart = true)
    @Named("GuiConfig")
    override fun loadConfig(): Map<String, ConfiguredGui> = super.loadConfig()

    override fun processFile(file: File): Map<String, ConfiguredGui> {
        val mapType = mapper.typeFactory
            .constructMapType(Map::class.java, String::class.java, ConfiguredGui::class.java)
        return mapper.readValue(file, mapType)
    }
}