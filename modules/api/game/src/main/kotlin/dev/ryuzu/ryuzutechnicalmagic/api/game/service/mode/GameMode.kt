package dev.ryuzu.ryuzutechnicalmagic.api.game.service.mode

import dev.ryuzu.ryuzutechnicalmagic.api.core.model.configuration.util.gui.GuiAction

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
            dev.ryuzu.ryuzutechnicalmagic.api.game.service.mode.GameMode.CarryTnt -> GuiAction.CHANGE_CARRY_TNT
            dev.ryuzu.ryuzutechnicalmagic.api.game.service.mode.GameMode.CarrySmallTnt -> GuiAction.CHANGE_CARRY_MINI_TNT
            dev.ryuzu.ryuzutechnicalmagic.api.game.service.mode.GameMode.CaptureWool -> GuiAction.CHANGE_CAPTURE_FOOL
            dev.ryuzu.ryuzutechnicalmagic.api.game.service.mode.GameMode.SteelJewelry -> GuiAction.CHANGE_STEEL_JEWELRY
            dev.ryuzu.ryuzutechnicalmagic.api.game.service.mode.GameMode.BreakCore -> GuiAction.CHANGE_BREAK_CORE
            dev.ryuzu.ryuzutechnicalmagic.api.game.service.mode.GameMode.CarryBigTnt -> GuiAction.CHANGE_PAYLOAD
            dev.ryuzu.ryuzutechnicalmagic.api.game.service.mode.GameMode.BattleRoyale -> GuiAction.CHANGE_BATTLE_ROYALE
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