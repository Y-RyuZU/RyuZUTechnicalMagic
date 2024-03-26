package com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.module

import com.fasterxml.jackson.databind.MapperFeature
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.json.JsonMapper
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper
import com.fasterxml.jackson.module.kotlin.KotlinModule
import com.github.ryuzu.ryuzutechnicalmagiccore.RyuZUTechnicalMagicCore
import org.koin.core.annotation.Module
import org.koin.core.annotation.Named
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject


@Module
class ConfigurationModule : KoinComponent {
    private val instance: RyuZUTechnicalMagicCore by inject()

    @Named("folder")
    fun provideFolder() = instance.dataFolder

    fun provideObjectMapper() = YAMLMapper.builder()
        .enable(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES)
        .addModule(KotlinModule.Builder().build())
        .build()
}