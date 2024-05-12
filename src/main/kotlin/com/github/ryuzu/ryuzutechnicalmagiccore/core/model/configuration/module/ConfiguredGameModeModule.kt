package com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.module

import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.general.ConfiguredGeneralParameter
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.game.mode.ConfiguredGameMode
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.util.gui.ConfiguredGui
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.game.mode.GameMode
import org.koin.core.annotation.Module
import org.koin.core.annotation.Named
import org.koin.core.annotation.Single
import java.io.File

@Module
class ConfiguredGameModeModule :
    AbstractConfigurationModule<Map<GameMode, ConfiguredGameMode>, Map<GameMode, ConfiguredGameMode>>() {

    override val fileName: String = "game"

    @Single(createdAtStart = true)
    @Named("GameModeConfig")
    override fun loadConfig(): Map<GameMode, ConfiguredGameMode> = super.loadConfig()

    override fun processFile(file: File): Map<GameMode, ConfiguredGameMode> {
        val mapType = mapper.typeFactory
            .constructMapType(Map::class.java, GameMode::class.java, ConfiguredGameMode::class.java)
        return mapper.readValue(file, mapType)
    }
}