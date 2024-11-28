package dev.ryuzu.ryuzutechnicalmagic.core.impl.model.configuration.module

import com.charleskorn.kaml.decodeFromStream
import dev.ryuzu.ryuzutechnicalmagic.api.core.model.configuration.game.mode.ConfiguredGameMode
import dev.ryuzu.ryuzutechnicalmagic.api.core.model.game.mode.GameMode
import org.koin.core.annotation.Module
import org.koin.core.annotation.Named
import org.koin.core.annotation.Single
import java.io.InputStream

@Module
class ConfiguredGameModeModule :
    AbstractConfigurationModule<Map<GameMode, ConfiguredGameMode>, Map<GameMode, ConfiguredGameMode>>() {

    override val fileName: String = "game"

    @Single(createdAtStart = true)
    @Named("GameModeConfig")
    override fun loadConfig(): Map<GameMode, ConfiguredGameMode> = super.loadConfig()

    override fun processStream(stream: InputStream): Map<GameMode, ConfiguredGameMode> = kaml.decodeFromStream(stream)
}