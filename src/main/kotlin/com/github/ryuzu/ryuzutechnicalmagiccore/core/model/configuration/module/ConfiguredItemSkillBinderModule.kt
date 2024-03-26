package com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.module

import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.skill.ConfiguredSkillSet
import org.koin.core.annotation.Module
import org.koin.core.annotation.Single
import java.io.File

@Module
class ConfiguredItemSkillBinderModule : AbstractConfigurationModule<HashMap<String, ConfiguredSkillSet>, ConfiguredSkillSet>() {
    companion object {
        private const val SKILL_SETS_PATH = "skill_sets"
    }

    @Single
    override fun loadConfig(): HashMap<String, ConfiguredSkillSet> = super.loadConfig()

    override fun processFile(file: File): ConfiguredSkillSet {
        return mapper.readValue(File(file, SKILL_SETS_PATH), ConfiguredSkillSet::class.java)
    }
}