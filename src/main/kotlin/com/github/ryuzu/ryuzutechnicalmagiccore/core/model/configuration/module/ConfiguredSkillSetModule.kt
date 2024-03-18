package com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.module

import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.skill.ConfiguredSkillParams
import java.io.File

class ConfiguredSkillSetModule: AbstractConfigurationModule<HashMap<String, ConfiguredSkillParams>, ConfiguredSkillParams>() {
    override fun processFile(file: File): ConfiguredSkillParams {
        return mapper.readValue(file, ConfiguredSkillParams::class.java)
    }
}