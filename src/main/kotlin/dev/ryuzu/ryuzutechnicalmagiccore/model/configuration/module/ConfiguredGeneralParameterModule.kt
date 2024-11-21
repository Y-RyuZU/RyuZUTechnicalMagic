package dev.ryuzu.ryuzutechnicalmagiccore.model.configuration.module

import com.charleskorn.kaml.decodeFromStream
import dev.ryuzu.ryuzutechnicalmagiccore.model.configuration.game.mode.ConfiguredGameMode
import dev.ryuzu.ryuzutechnicalmagiccore.model.configuration.general.ConfiguredGeneralParameter
import dev.ryuzu.ryuzutechnicalmagiccore.model.game.mode.GameMode
import org.koin.core.annotation.Module
import org.koin.core.annotation.Single
import java.io.File
import java.io.InputStream

@Module
class ConfiguredGeneralParameterModule :
    AbstractConfigurationModule<ConfiguredGeneralParameter, ConfiguredGeneralParameter>() {

    override val fileName: String = "general"

    @Single(createdAtStart = true)
    override fun loadConfig(): ConfiguredGeneralParameter = super.loadConfig()

    override fun processStream(stream: InputStream): ConfiguredGeneralParameter = kaml.decodeFromStream(stream)
}