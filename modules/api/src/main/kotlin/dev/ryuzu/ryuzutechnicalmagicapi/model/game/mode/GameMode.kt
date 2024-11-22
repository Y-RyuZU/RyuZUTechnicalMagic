package dev.ryuzu.ryuzutechnicalmagicapi.model.game.mode

import dev.ryuzu.ryuzutechnicalmagicapi.model.configuration.util.gui.GuiAction

enum class GameMode {
    CarryTnt,
    CarrySmallTnt,
    CaptureWool,
    SteelJewelry,
    BreakCore,
    CarryBigTnt,
    BattleRoyale;

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