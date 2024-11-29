package dev.ryuzu.ryuzutechnicalmagic.core.impl.model.configuration.module

import com.charleskorn.kaml.decodeFromStream
import org.koin.core.annotation.Module
import org.koin.core.annotation.Named
import org.koin.core.annotation.Single
import java.io.InputStream

@Module
class ConfiguredGuiModule :
    AbstractConfigurationModule<Map<String, dev.ryuzu.ryuzutechnicalmagic.api.core.model.configuration.util.gui.ConfiguredGui>, Map<String, dev.ryuzu.ryuzutechnicalmagic.api.core.model.configuration.util.gui.ConfiguredGui>>() {
    override val folderName: String = "guis"

    @Single(createdAtStart = true)
    @Named("GuiConfig")
    override fun loadConfig(): Map<String, dev.ryuzu.ryuzutechnicalmagic.api.core.model.configuration.util.gui.ConfiguredGui> = super.loadConfig()

    override fun processStream(stream: InputStream): Map<String, dev.ryuzu.ryuzutechnicalmagic.api.core.model.configuration.util.gui.ConfiguredGui> = kaml.decodeFromStream(stream)
}