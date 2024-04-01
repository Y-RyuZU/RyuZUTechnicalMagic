package com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.module

import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.game.entry.ConfiguredEntry
import org.koin.core.annotation.Module
import org.koin.core.annotation.Single
import java.io.File

@Module
class ConfiguredEntryModule : AbstractConfigurationModule<ConfiguredEntry, ConfiguredEntry>() {
    override val fileName: String = "entry"

    @Single(createdAtStart = true)
    override fun loadConfig(): ConfiguredEntry = super.loadConfig()

    override fun processFile(file: File): ConfiguredEntry {
        return mapper.readValue(file, ConfiguredEntry::class.java)
    }
}