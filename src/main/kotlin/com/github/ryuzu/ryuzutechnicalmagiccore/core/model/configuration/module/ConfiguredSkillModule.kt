package com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.module

import com.fasterxml.jackson.dataformat.yaml.YAMLParser
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.skill.ConfiguredSkillParams
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.util.gui.ConfiguredGui
import org.koin.core.annotation.Factory
import org.koin.core.annotation.Module
import org.koin.core.annotation.Named
import org.koin.core.annotation.Single
import java.io.File

@Module
class ConfiguredSkillModule :
    AbstractConfigurationModule<HashMap<String, ConfiguredSkillParams>, HashMap<String, ConfiguredSkillParams>>() {
    override val folderName: String = "skills"

    @Factory
    @Named("SkillConfig")
    override fun loadConfig(): HashMap<String, ConfiguredSkillParams> = super.loadConfig()

    override fun processFile(file: File): HashMap<String, ConfiguredSkillParams> {
        val mapType = mapper.typeFactory
            .constructMapType(HashMap::class.java, String::class.java, ConfiguredSkillParams::class.java)
        return mapper.readValue(file, mapType)
    }
}