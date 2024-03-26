package com.github.ryuzu.ryuzutechnicalmagiccore.core.model.game.mode

import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.game.stage.ConfiguredStage
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.game.team.IGameTeam
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.game.team.ConfiguredTeam
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.util.gui.GuiAction
import org.koin.core.component.KoinComponent

enum class GameMode : KoinComponent {
    CarryTnt {
        override fun start(stage: ConfiguredStage, world: String): IGameService {
            TODO("Not yet implemented")
        }
    },
    CarrySmallTnt {
        override fun start(stage: ConfiguredStage, world: String): IGameService = TODO("Not yet implemented")
    },
    CaptureWool {
        override fun start(stage: ConfiguredStage, world: String): IGameService = TODO("Not yet implemented")
    },
    SteelJewelry {
        override fun start(stage: ConfiguredStage, world: String): IGameService = TODO("Not yet implemented")
    },
    BreakCore {
        override fun start(stage: ConfiguredStage, world: String): IGameService = TODO("Not yet implemented")
    },
    CarryBigTnt {
        override fun start(stage: ConfiguredStage, world: String): IGameService = TODO("Not yet implemented")
    },
    BattleRoyale {
        override fun start(stage: ConfiguredStage, world: String): IGameService = TODO("Not yet implemented")
    };
    
    abstract fun start(stage: ConfiguredStage, world: String): IGameService
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
        const val CONST_CARRY_TNT = "CARRY_TNT"
        const val CONST_CARRY_MINI_TNT = "CARRY_MINI_TNT"
        const val CONST_CAPTURE_WOOL = "CAPTURE_WOOL"
        const val CONST_STEEL_JEWELRY = "STEEL_JEWELRY"
        const val CONST_BREAK_CORE = "BREAK_CORE"
        const val CONST_PAYLOAD = "PAYLOAD"
        const val CONST_BATTLE_ROYALE = "BATTLE_ROYALE"
    }
}