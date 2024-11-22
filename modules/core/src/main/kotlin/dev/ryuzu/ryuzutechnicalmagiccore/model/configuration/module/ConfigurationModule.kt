package dev.ryuzu.ryuzutechnicalmagiccore.model.configuration.module

import com.charleskorn.kaml.Yaml
import com.github.ryuzu.ryuzutechnicalmagiccore.RyuZUTechnicalMagicCore
import dev.ryuzu.ryuzutechnicalmagiccore.model.skill.ISkill
import kotlinx.serialization.KSerializer
import kotlinx.serialization.modules.SerializersModule
import org.koin.core.annotation.Module
import org.koin.core.annotation.Named
import org.koin.core.annotation.Single
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import org.reflections.Reflections
import org.reflections.scanners.Scanners
import org.reflections.util.ConfigurationBuilder
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
    fun provideSnakeYaml(): Yaml = Yaml.default
}