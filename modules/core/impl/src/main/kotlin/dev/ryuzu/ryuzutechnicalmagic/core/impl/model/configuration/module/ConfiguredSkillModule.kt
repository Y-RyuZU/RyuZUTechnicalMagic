package dev.ryuzu.ryuzutechnicalmagic.core.impl.model.configuration.module

import com.charleskorn.kaml.decodeFromStream
import dev.ryuzu.ryuzutechnicalmagic.api.core.model.configuration.skill.ConfiguredSkillParams
import org.koin.core.annotation.Factory
import org.koin.core.annotation.Module
import org.koin.core.annotation.Named
import java.io.InputStream

@Module
class ConfiguredSkillModule :
    AbstractConfigurationModule<Map<String, ConfiguredSkillParams>, Map<String, ConfiguredSkillParams>>() {
    override val folderName: String = "skills"

    @Factory
    @Named("SkillConfig")
    override fun loadConfig(): Map<String, ConfiguredSkillParams> = super.loadConfig()

    override fun processStream(stream: InputStream): Map<String, ConfiguredSkillParams> = kaml.decodeFromStream(stream)
}