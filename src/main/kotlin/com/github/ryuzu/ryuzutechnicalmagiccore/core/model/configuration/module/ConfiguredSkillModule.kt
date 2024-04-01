package com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.module

import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.skill.ConfiguredSkillParams
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.util.gui.ConfiguredGui
import org.koin.core.annotation.Module
import org.koin.core.annotation.Named
import org.koin.core.annotation.Single
import java.io.File

@Module
class ConfiguredSkillModule :
    AbstractConfigurationModule<Map<String, ConfiguredSkillParams>, Map<String, ConfiguredSkillParams>>() {
    override val folderName: String = "skills"

    @Single(createdAtStart = true)
    @Named("SkillConfig")
    override fun loadConfig(): Map<String, ConfiguredSkillParams> = super.loadConfig()

    override fun processFile(file: File): Map<String, ConfiguredSkillParams> {
        val mapType = mapper.typeFactory
            .constructMapType(Map::class.java, String::class.java, ConfiguredSkillParams::class.java)
        return mapper.readValue(file, mapType)
    }
}