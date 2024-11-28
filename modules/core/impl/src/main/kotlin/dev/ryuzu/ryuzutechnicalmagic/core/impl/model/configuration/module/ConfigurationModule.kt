package dev.ryuzu.ryuzutechnicalmagic.core.impl.model.configuration.module

import com.charleskorn.kaml.Yaml
import org.koin.core.annotation.Module
import org.koin.core.annotation.Named
import org.koin.core.annotation.Single
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import java.io.File


@Module
class ConfigurationModule : KoinComponent {
//    private val instance: RyuZUTechnicalMagicCore by inject()

    @Named("dataFolder")
    @Single
    fun provideDataFolder(): File = instance.dataFolder

    @Named("worldContainer")
    @Single
    fun provideWorldContainer(): File = instance.server.worldContainer

    @Single
    fun provideSnakeYaml(): Yaml = Yaml.default
}