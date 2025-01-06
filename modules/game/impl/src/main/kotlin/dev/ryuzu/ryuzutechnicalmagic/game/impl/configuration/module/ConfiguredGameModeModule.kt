package dev.ryuzu.ryuzutechnicalmagic.game.impl.configuration.module

import com.charleskorn.kaml.decodeFromStream
import dev.ryuzu.ryuzutechnicalmagic.api.game
import dev.ryuzu.ryuzutechnicalmagic.api.game.data.mode.ConfiguredGameMode
import dev.ryuzu.ryuzutechnicalmagic.api.game.service.mode.GameMode
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