package dev.ryuzu.ryuzutechnicalmagic.core.impl.model.game.mode

import dev.ryuzu.ryuzutechnicalmagic.api.core.model.configuration.game.mode.ConfiguredGameMode
import dev.ryuzu.ryuzutechnicalmagic.api.core.model.configuration.game.stage.ConfiguredStage
import dev.ryuzu.ryuzutechnicalmagic.api.core.model.entity.IPlayer
import dev.ryuzu.ryuzutechnicalmagic.api.core.model.game.entry.IEntryGameService
import dev.ryuzu.ryuzutechnicalmagic.api.core.model.game.mode.GameMode
import dev.ryuzu.ryuzutechnicalmagic.api.core.model.game.mode.IGameService
import dev.ryuzu.ryuzutechnicalmagic.api.core.model.game.mode.carrytnt.ICarryTntService
import org.koin.core.component.KoinComponent
import org.koin.core.component.get
import org.koin.core.parameter.parametersOf

object GameServiceUtility : KoinComponent {
    fun createGameService(
        gameMode: GameMode,
        world: String,
        config: ConfiguredGameMode,
        stage: ConfiguredStage,
        entryService: IEntryGameService,
        entryPlayers: Set<IPlayer>
    ): IGameService {
        val parameters = parametersOf(
            world,
            config,
            stage,
            entryService,
            entryPlayers
        )
        return when (gameMode) {
            GameMode.CarryTnt -> get<ICarryTntService> { parameters }
            GameMode.CaptureWool -> throw UnsupportedOperationException("Not implemented yet")
            GameMode.BreakCore -> throw UnsupportedOperationException("Not implemented yet")
            GameMode.SteelJewelry -> throw UnsupportedOperationException("Not implemented yet")
            GameMode.CarryBigTnt -> throw UnsupportedOperationException("Not implemented yet")
            GameMode.BattleRoyale -> throw UnsupportedOperationException("Not implemented yet")
            GameMode.CarrySmallTnt -> throw UnsupportedOperationException("Not implemented yet")
        }
    }
}