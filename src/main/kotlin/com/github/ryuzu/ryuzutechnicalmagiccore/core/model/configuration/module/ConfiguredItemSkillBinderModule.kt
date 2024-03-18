package com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.module

import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.skill.ConfiguredSkillSet
import org.koin.core.annotation.Module
import java.io.File

@Module
class ConfiguredItemSkillBinderModule : AbstractConfigurationModule<HashMap<String, ConfiguredSkillSet>, ConfiguredSkillSet>() {
    override fun processFile(file: File): ConfiguredSkillSet {
        return mapper.readValue(file, ConfiguredSkillSet::class.java)
    }
}