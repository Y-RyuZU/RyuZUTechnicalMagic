package com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.module

import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.skill.ConfiguredSkillSet
import org.koin.core.annotation.Factory
import org.koin.core.annotation.Module
import org.koin.core.annotation.Named
import org.koin.core.annotation.Single
import java.io.File

@Module
class ConfiguredSkillSetModule :
    AbstractConfigurationModule<HashMap<String, ConfiguredSkillSet>, HashMap<String, ConfiguredSkillSet>>() {
    override val folderName: String = "skill-sets"

    @Factory
    @Named("SkillSetConfig")
    override fun loadConfig(): HashMap<String, ConfiguredSkillSet> = super.loadConfig()

    override fun processFile(file: File): HashMap<String, ConfiguredSkillSet> {
        val mapType = mapper.typeFactory
            .constructMapType(HashMap::class.java, String::class.java, ConfiguredSkillSet::class.java)
        return mapper.readValue(file, mapType)
    }
}