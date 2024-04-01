package com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.module

import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.game.general.ConfiguredGeneralParameter
import org.koin.core.annotation.Module
import org.koin.core.annotation.Single
import java.io.File

@Module
class ConfiguredGeneralParameterModule :
    AbstractConfigurationModule<ConfiguredGeneralParameter, ConfiguredGeneralParameter>() {

    override val fileName: String = "general"

    @Single(createdAtStart = true)
    override fun loadConfig(): ConfiguredGeneralParameter = super.loadConfig()

    override fun processFile(file: File): ConfiguredGeneralParameter {
        return mapper.readValue(file, ConfiguredGeneralParameter::class.java)
    }
}