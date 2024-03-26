package com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.module

import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.skill.ConfiguredSkillParams
import org.koin.core.annotation.Module
import org.koin.core.annotation.Single
import java.io.File

@Module
class ConfiguredSkillSetModule :
    AbstractConfigurationModule<HashMap<String, ConfiguredSkillParams>, ConfiguredSkillParams>() {
    companion object {
        private const val SKILLS_PATH = "skills"
    }

    @Single
    override fun loadConfig(): HashMap<String, ConfiguredSkillParams> = super.loadConfig()

    override fun processFile(file: File): ConfiguredSkillParams {
        return mapper.readValue(File(file, SKILLS_PATH), ConfiguredSkillParams::class.java)
    }
}