package dev.ryuzu.ryuzutechnicalmagic.core.impl.model.configuration.module

import com.charleskorn.kaml.decodeFromStream
import dev.ryuzu.ryuzutechnicalmagic.api.core.model.configuration.general.ConfiguredGeneralParameter
import org.koin.core.annotation.Module
import org.koin.core.annotation.Single
import java.io.InputStream

@Module
class ConfiguredGeneralParameterModule :
    AbstractConfigurationModule<ConfiguredGeneralParameter, ConfiguredGeneralParameter>() {

    override val fileName: String = "general"

    @Single(createdAtStart = true)
    override fun loadConfig(): ConfiguredGeneralParameter = super.loadConfig()

    override fun processStream(stream: InputStream): ConfiguredGeneralParameter = kaml.decodeFromStream(stream)
}