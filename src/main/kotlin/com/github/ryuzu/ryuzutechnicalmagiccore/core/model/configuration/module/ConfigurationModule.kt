package com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.module

import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.databind.MapperFeature
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper
import com.fasterxml.jackson.module.kotlin.KotlinModule
import com.github.ryuzu.ryuzutechnicalmagiccore.RyuZUTechnicalMagicCore
import org.koin.core.annotation.Module
import org.koin.core.annotation.Named
import org.koin.core.annotation.Single
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import java.io.File


@Module
class ConfigurationModule : KoinComponent {
    private val instance: RyuZUTechnicalMagicCore by inject()

    @Named("dataFolder")
    @Single
    fun provideDataFolder(): File = instance.dataFolder

    @Named("worldContainer")
    @Single
    fun provideWorldContainer(): File = instance.server.worldContainer

    @Single
    fun provideYamlMapper(): YAMLMapper = YAMLMapper.builder()
        .enable(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES)
        .disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES)
        .addModule(KotlinModule.Builder().build())
        .build()
}