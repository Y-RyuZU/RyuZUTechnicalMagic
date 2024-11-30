package dev.ryuzu.ryuzutechnicalmagic.core.impl.model.configuration.module

import com.charleskorn.kaml.decodeFromStream
import dev.ryuzu.ryuzutechnicalmagic.api.core.model.configuration.skill.ConfiguredSkillSet
import org.koin.core.annotation.Factory
import org.koin.core.annotation.Module
import org.koin.core.annotation.Named
import java.io.InputStream

@Module
class ConfiguredSkillSetModule :
    AbstractConfigurationModule<Map<String, ConfiguredSkillSet>, Map<String, ConfiguredSkillSet>>() {
    override val folderName: String = "skill-sets"

    @Factory
    @Named("SkillSetConfig")
    override fun loadConfig(): Map<String, ConfiguredSkillSet> = super.loadConfig()

    override fun processStream(stream: InputStream): Map<String, ConfiguredSkillSet> = kaml.decodeFromStream(stream)
}