package com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.module

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory
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

    @Named("skill_path")
    fun provideSkillPath() = "skills"
    @Named("item_skill_binder_path")
    fun provideItemSkillBinderPath() = "items"

    fun provideObjectMapper() = ObjectMapper(YAMLFactory()).registerModule(KotlinModule())
}