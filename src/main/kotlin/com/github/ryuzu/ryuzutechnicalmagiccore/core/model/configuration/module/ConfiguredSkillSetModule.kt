package com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.module

import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.skill.ConfiguredSkillSet
import org.koin.core.annotation.Module
import org.koin.core.annotation.Named
import org.koin.core.annotation.Single
import java.io.File

@Module
class ConfiguredSkillSetModule :
    AbstractConfigurationModule<Map<String, ConfiguredSkillSet>, Map<String, ConfiguredSkillSet>>() {
    override val folderName: String = "skill-sets"

    @Single(createdAtStart = true)
    @Named("SkillSetConfig")
    override fun loadConfig(): Map<String, ConfiguredSkillSet> = super.loadConfig()

    override fun processFile(file: File): Map<String, ConfiguredSkillSet> {
        val mapType = mapper.typeFactory
            .constructMapType(Map::class.java, String::class.java, ConfiguredSkillSet::class.java)
        return mapper.readValue(file, mapType)
    }
}