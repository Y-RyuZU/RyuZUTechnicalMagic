package dev.ryuzu.ryuzutechnicalmagic.core.impl.model.configuration.module

import com.charleskorn.kaml.decodeFromStream
import dev.ryuzu.ryuzutechnicalmagic.api.core.model.configuration.game.entry.ConfiguredEntry
import org.koin.core.annotation.Module
import org.koin.core.annotation.Single
import java.io.InputStream

@Module
class ConfiguredEntryModule : AbstractConfigurationModule<ConfiguredEntry, ConfiguredEntry>() {
    override val fileName: String = "entry"

    @Single(createdAtStart = true)
    override fun loadConfig(): ConfiguredEntry = super.loadConfig()

    override fun processStream(stream: InputStream): ConfiguredEntry = kaml.decodeFromStream(stream)
}