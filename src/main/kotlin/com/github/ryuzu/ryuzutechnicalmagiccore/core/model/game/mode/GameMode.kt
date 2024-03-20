package com.github.ryuzu.ryuzutechnicalmagiccore.core.model.game.mode

import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.game.team.IGameTeam
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.game.stage.ConfiguredTeam
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.util.gui.GuiAction
import java.util.*

enum class GameMode {
    CARRY_TNT {
        override fun start(players: Set<UUID>): IGameService {

            TODO("Not yet implemented")
        }

        override fun createTeam(property: ConfiguredTeam): IGameTeam = IGameTeam.CarryTNTTeam(property)
        override fun createGameData(stage: String): GameData = GameData.TeamGameData.CarryTNTData()
        override fun getGuiAction(): GuiAction = GuiAction.CHANGE_CARRY_TNT

    },
    CARRY_MINI_TNT {
        override fun start(players: Set<UUID>): IGameService = TODO("Not yet implemented")
        override fun createTeam(property: ConfiguredTeam): IGameTeam = TODO("Not yet implemented")
        override fun createGameData(stage: String): GameData = TODO("Not yet implemented")
        override fun getGuiAction(): GuiAction = GuiAction.CHANGE_CARRY_MINI_TNT
    },
    CAPTURE_WOOL {
        override fun start(players: Set<UUID>): IGameService = TODO("Not yet implemented")
        override fun createTeam(property: ConfiguredTeam): IGameTeam = TODO("Not yet implemented")
        override fun createGameData(stage: String): GameData = TODO("Not yet implemented")
        override fun getGuiAction(): GuiAction = GuiAction.CHANGE_CAPTURE_FOOL
    },
    STEEL_JEWELRY {
        override fun start(players: Set<UUID>): IGameService = TODO("Not yet implemented")
        override fun createTeam(property: ConfiguredTeam): IGameTeam = TODO("Not yet implemented")
        override fun createGameData(stage: String): GameData = TODO("Not yet implemented")
        override fun getGuiAction(): GuiAction = GuiAction.CHANGE_STEEL_JEWELRY
    },
    BREAK_CORE {
        override fun start(players: Set<UUID>): IGameService = TODO("Not yet implemented")
        override fun createTeam(property: ConfiguredTeam): IGameTeam = TODO("Not yet implemented")
        override fun createGameData(stage: String): GameData = TODO("Not yet implemented")
        override fun getGuiAction(): GuiAction = GuiAction.CHANGE_BREAK_CORE
    },
    PAYLOAD {
        override fun start(players: Set<UUID>): IGameService = TODO("Not yet implemented")
        override fun createTeam(property: ConfiguredTeam): IGameTeam = TODO("Not yet implemented")
        override fun createGameData(stage: String): GameData = TODO("Not yet implemented")
        override fun getGuiAction(): GuiAction = GuiAction.CHANGE_PAYLOAD
    },
    BATTLE_ROYALE {
        override fun start(players: Set<UUID>): IGameService = TODO("Not yet implemented")
        override fun createTeam(property: ConfiguredTeam): IGameTeam = TODO("Not yet implemented")
        override fun createGameData(stage: String): GameData = TODO("Not yet implemented")
        override fun getGuiAction(): GuiAction = GuiAction.CHANGE_BATTLE_ROYALE
    };

    abstract fun start(players: Set<UUID>): IGameService
    abstract fun createTeam(property: ConfiguredTeam): IGameTeam
    abstract fun createGameData(stage: String): GameData
    abstract fun getGuiAction(): GuiAction

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