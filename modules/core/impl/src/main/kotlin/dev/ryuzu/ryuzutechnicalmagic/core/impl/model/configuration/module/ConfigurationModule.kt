package dev.ryuzu.ryuzutechnicalmagic.core.impl.model.configuration.module

import com.charleskorn.kaml.Yaml
import org.koin.core.annotation.Module
import org.koin.core.annotation.Named
import org.koin.core.annotation.Single
import org.koin.core.component.KoinComponent
import java.io.File


@Module
class ConfigurationModule : KoinComponent {
    @Single
    fun provideSnakeYaml(): Yaml = Yaml.default
}