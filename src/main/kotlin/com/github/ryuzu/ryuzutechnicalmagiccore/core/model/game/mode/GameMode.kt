package com.github.ryuzu.ryuzutechnicalmagiccore.core.model.game.mode

import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.game.mode.ConfiguredGameMode
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.game.stage.ConfiguredStage
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.util.gui.GuiAction
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.game.entry.IEntryGameService
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.game.mode.carrytnt.ICarryTntService
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.entity.IPlayer
import org.koin.core.component.KoinComponent
import org.koin.core.component.get
import org.koin.core.parameter.parametersOf

enum class GameMode : KoinComponent {
    CarryTnt {
        override fun getService(
            world: String,
            config: ConfiguredGameMode,
            stage: ConfiguredStage,
            entryService: IEntryGameService,
            entryPlayers: Set<IPlayer>,
        ): IGameService
            = get<ICarryTntService>{ parametersOf(world, config, stage, entryService, entryPlayers) }
    },
    CarrySmallTnt {
        override fun getService(
            world: String,
            config: ConfiguredGameMode,
            stage: ConfiguredStage,
            entryService: IEntryGameService,
            entryPlayers: Set<IPlayer>,
        ): IGameService = TODO("Not yet implemented")
    },
    CaptureWool {
        override fun getService(
            world: String,
            config: ConfiguredGameMode,
            stage: ConfiguredStage,
            entryService: IEntryGameService,
            entryPlayers: Set<IPlayer>,
        ): IGameService = TODO("Not yet implemented")
    },
    SteelJewelry {
        override fun getService(
            world: String,
            config: ConfiguredGameMode,
            stage: ConfiguredStage,
            entryService: IEntryGameService,
            entryPlayers: Set<IPlayer>,
        ): IGameService = TODO("Not yet implemented")
    },
    BreakCore {
        override fun getService(
            world: String,
            config: ConfiguredGameMode,
            stage: ConfiguredStage,
            entryService: IEntryGameService,
            entryPlayers: Set<IPlayer>,
        ): IGameService = TODO("Not yet implemented")
    },
    CarryBigTnt {
        override fun getService(
            world: String,
            config: ConfiguredGameMode,
            stage: ConfiguredStage,
            entryService: IEntryGameService,
            entryPlayers: Set<IPlayer>,
        ): IGameService = TODO("Not yet implemented")
    },
    BattleRoyale {
        override fun getService(
            world: String,
            config: ConfiguredGameMode,
            stage: ConfiguredStage,
            entryService: IEntryGameService,
            entryPlayers: Set<IPlayer>,
        ): IGameService = TODO("Not yet implemented")
    };
    
    abstract fun getService(
        world: String,
        config: ConfiguredGameMode,
        stage: ConfiguredStage,
        entryService: IEntryGameService,
        entryPlayers: Set<IPlayer>,
    ): IGameService
    fun getGuiAction(): GuiAction {
        return when(this) {
            CarryTnt -> GuiAction.CHANGE_CARRY_TNT
            CarrySmallTnt -> GuiAction.CHANGE_CARRY_MINI_TNT
            CaptureWool -> GuiAction.CHANGE_CAPTURE_FOOL
            SteelJewelry -> GuiAction.CHANGE_STEEL_JEWELRY
            BreakCore -> GuiAction.CHANGE_BREAK_CORE
            CarryBigTnt -> GuiAction.CHANGE_PAYLOAD
            BattleRoyale -> GuiAction.CHANGE_BATTLE_ROYALE
        }
    }
    
    companion object {
        const val CONST_CARRY_TNT = "CarryTnt"
        const val CONST_CARRY_SMALL_TNT = "CarrySmallTnt"
        const val CONST_CAPTURE_WOOL = "CaptureWool"
        const val CONST_STEEL_JEWELRY = "STEEL_JEWELRY"
        const val CONST_BREAK_CORE = "BREAK_CORE"
        const val CONST_CARRY_BIG_TNT = "CARRY_BIG_TNT"
        const val CONST_BATTLE_ROYALE = "BATTLE_ROYALE"
    }
}