package dev.ryuzu.ryuzutechnicalmagiccore.model.configuration.module

import com.charleskorn.kaml.decodeFromStream
import dev.ryuzu.ryuzutechnicalmagiccore.model.configuration.util.gui.ConfiguredGui
import org.koin.core.annotation.Module
import org.koin.core.annotation.Named
import org.koin.core.annotation.Single
import java.io.File
import java.io.InputStream

@Module
class ConfiguredGuiModule :
    AbstractConfigurationModule<Map<String, ConfiguredGui>, Map<String, ConfiguredGui>>() {
    override val folderName: String = "guis"

    @Single(createdAtStart = true)
    @Named("GuiConfig")
    override fun loadConfig(): Map<String, ConfiguredGui> = super.loadConfig()

    override fun processStream(stream: InputStream): Map<String, ConfiguredGui> = kaml.decodeFromStream(stream)
}