package dev.ryuzu.ryuzutechnicalmagiccore.model.configuration.module

import com.charleskorn.kaml.decodeFromStream
import dev.ryuzu.ryuzutechnicalmagiccore.model.configuration.game.anomaly.ConfiguredAnomaly
import dev.ryuzu.ryuzutechnicalmagiccore.model.configuration.skill.ConfiguredSkillSet
import dev.ryuzu.ryuzutechnicalmagiccore.model.game.stage.anomaly.AnomalyType
import org.koin.core.annotation.Factory
import org.koin.core.annotation.Module
import org.koin.core.annotation.Named
import org.koin.core.annotation.Single
import java.io.File
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