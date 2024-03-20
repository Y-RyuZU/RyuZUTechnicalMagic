package com.github.ryuzu.ryuzutechnicalmagiccore.core.model.game.mode

import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.game.mode.ConfiguredGameMode
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.game.stage.ConfiguredStage
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.game.player.IGamePlayer
import org.koin.core.component.inject
import org.koin.core.parameter.parametersOf
import org.koin.core.qualifier.named
import java.util.*

abstract class AbstractGameService(
    override val world: String,
    protected open val stage: ConfiguredStage,
    entryPlayers: Set<UUID>,
) : IGameService {
    protected open val gameModeParameter: ConfiguredGameMode by inject { parametersOf(stage.gameProperty.getGameMode()) }
    protected open val players: MutableSet<IGamePlayer> = entryPlayers.map { createPlayer(it) }.toMutableSet()
    protected open abstract val gameData: GameData
    protected open abstract fun createPlayer(player: UUID): IGamePlayer

    override fun joinGameMidway(player: UUID) {
        players.add(createPlayer(player))
    }
}