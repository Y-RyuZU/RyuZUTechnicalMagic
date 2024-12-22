package dev.ryuzu.ryuzutechnicalmagic.core.impl.model.configuration.module

import com.charleskorn.kaml.decodeFromStream
import dev.ryuzu.ryuzutechnicalmagic.api.core.data.gui.SerGui
import org.koin.core.annotation.Module
import org.koin.core.annotation.Named
import org.koin.core.annotation.Single
import java.io.InputStream

@Module
class ConfiguredGuiModule :
    AbstractConfigurationModule<Map<String, SerGui>, Map<String, SerGui>>() {
    override val folderName: String = "guis"

    @Single(createdAtStart = true)
    @Named("GuiConfig")
    override fun loadConfig(): Map<String, SerGui> = super.loadConfig()

    override fun processStream(stream: InputStream): Map<String, SerGui> = kaml.decodeFromStream(stream)
}