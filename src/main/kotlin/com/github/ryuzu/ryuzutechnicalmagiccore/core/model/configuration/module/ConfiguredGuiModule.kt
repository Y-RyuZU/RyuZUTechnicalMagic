package com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.module

import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.util.gui.ConfiguredGui
import org.koin.core.annotation.Module
import org.koin.core.annotation.Single
import java.io.File

@Module
class ConfiguredGuiModule :
    AbstractConfigurationModule<HashMap<String, ConfiguredGui>, ConfiguredGui>() {
    companion object {
        private const val GUIS_PATH = "guis"
    }

    @Single
    override fun loadConfig(): HashMap<String, ConfiguredGui> = super.loadConfig()

    override fun processFile(file: File): ConfiguredGui {
        return mapper.readValue(File(file, GUIS_PATH), ConfiguredGui::class.java)
    }
}