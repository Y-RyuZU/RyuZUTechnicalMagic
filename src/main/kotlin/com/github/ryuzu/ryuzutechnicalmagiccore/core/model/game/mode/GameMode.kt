package com.github.ryuzu.ryuzutechnicalmagiccore.core.model.game.mode

import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.game.mode.service.data.GameData
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.game.team.GameTeam
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.game.team.TeamProperty
import java.util.*

enum class GameMode {
    CARRY_TNT {
        override fun start(players: Set<UUID>) {
            TODO("Not yet implemented")
        }

        override fun createTeam(property: TeamProperty): GameTeam = GameTeam.CarryTNTTeam(property)
        override fun createGameData(stage: String): GameData = GameData.TeamGameData.CarryTNTData(stage)
    },
    CARRY_MINI_TNT {
        override fun start(players: Set<UUID>) {
            TODO("Not yet implemented")
        }

        override fun createTeam(property: TeamProperty): GameTeam = TODO("Not yet implemented")
        override fun createGameData(stage: String): GameData = TODO("Not yet implemented")
    },
    CAPTURE_WOOL {
        override fun start(players: Set<UUID>) {
            TODO("Not yet implemented")
        }

        override fun createTeam(property: TeamProperty): GameTeam {
            TODO("Not yet implemented")
        }

        override fun createGameData(stage: String): GameData {
            TODO("Not yet implemented")
        }
    },
    STEEL_JEWELRY {
        override fun start(players: Set<UUID>) {
            TODO("Not yet implemented")
        }

        override fun createTeam(property: TeamProperty): GameTeam = TODO("Not yet implemented")
        override fun createGameData(stage: String): GameData = TODO("Not yet implemented")
    },
    BREAK_CORE {
        override fun start(players: Set<UUID>) {
            TODO("Not yet implemented")
        }

        override fun createTeam(property: TeamProperty): GameTeam = TODO("Not yet implemented")
        override fun createGameData(stage: String): GameData = TODO("Not yet implemented")
    },
    PAYLOAD {
        override fun start(players: Set<UUID>) {
            TODO("Not yet implemented")
        }
        
        override fun createTeam(property: TeamProperty): GameTeam = TODO("Not yet implemented")
        override fun createGameData(stage: String): GameData = TODO("Not yet implemented")
    },
    BATTLE_ROYALE {
        override fun start(players: Set<UUID>) {
            TODO("Not yet implemented")
        }

        override fun createTeam(property: TeamProperty): GameTeam = TODO("Not yet implemented")
        override fun createGameData(stage: String): GameData = TODO("Not yet implemented")
    };

    abstract fun start(players: Set<UUID>)
    abstract fun createTeam(property: TeamProperty): GameTeam
    abstract fun createGameData(stage: String): GameData
}